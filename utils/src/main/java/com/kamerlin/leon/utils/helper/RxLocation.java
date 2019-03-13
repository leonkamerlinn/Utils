package com.kamerlin.leon.utils.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class RxLocation {

    private static RxLocation INSTANCE;
    private int mMinTime = 0;
    private int mMinDistance = 0;
    private Location mCurrentBestLocation = null;
    private String mProvider = LocationManager.NETWORK_PROVIDER;
    private final LocationManager mLocationManager;
    private final LocationListener mLocationListener;
    private PublishSubject<Location> mLocationPublishSubject = PublishSubject.create();
    private PublishSubject<Boolean> mProviderStatusChangedPublisher = PublishSubject.create();

    private RxLocation(Context context) {
        mLocationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        mLocationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                if (location != null) {
                    if (isBetterLocation(location, mCurrentBestLocation)) {
                        mCurrentBestLocation = location;
                    }

                    mLocationPublishSubject.onNext(mCurrentBestLocation);
                }
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {}

            public void onProviderEnabled(String provider) {
                mProviderStatusChangedPublisher.onNext(true);
            }

            public void onProviderDisabled(String provider) {
                mProviderStatusChangedPublisher.onNext(false);
            }
        };
    }

    @Nullable
    public Location getCurrentBestLocation() {
        return mCurrentBestLocation;
    }


    public Observable<Location> getLocationObservable() {
        return mLocationPublishSubject;
    }

    public Observable<Boolean> getProviderStatusObservable() {
        return mProviderStatusChangedPublisher;
    }


    public static RxLocation getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (RxLocation.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RxLocation(context);
                }
            }
        }

        return INSTANCE;
    }

    public void stop() {
        // Remove the listener you previously added
        mLocationManager.removeUpdates(mLocationListener);
    }

    public void start() throws ProviderIsNotEnabledException {
        requestLocation();
    }

    @Nullable
    @SuppressLint("MissingPermission")
    private Location getLastKnownLocation() throws ProviderIsNotEnabledException {
        String locationProvider = LocationManager.GPS_PROVIDER;
        // Or use LocationManager.GPS_PROVIDER
        if (mLocationManager.isProviderEnabled(locationProvider)) {
            Location location = mLocationManager.getLastKnownLocation(locationProvider);
            if (location != null) {
                if (isBetterLocation(location, getCurrentBestLocation())) {
                    mCurrentBestLocation = location;
                }
                return mCurrentBestLocation;
            }
        } else {
            throw new ProviderIsNotEnabledException("Provider is not enabled");
        }

        return null;
    }

    @SuppressLint("MissingPermission")
    private void requestLocation() throws ProviderIsNotEnabledException {
        if (mLocationManager.isProviderEnabled(getProvider())) {
            mLocationManager.requestLocationUpdates(getProvider(), mMinTime, mMinDistance, mLocationListener);
        } else {
            throw new ProviderIsNotEnabledException("Provider is not enabled");
        }
    }

    public void setMinTime(int minTime) throws ProviderIsNotEnabledException {
        if (minTime != getMinTime()) {
            mMinTime = minTime;
            requestLocation();
        }
    }

    public int getMinTime() {
        return mMinTime;
    }

    public void setMinDistance(int minDistance) throws ProviderIsNotEnabledException {
        if (minDistance != getMinDistance()) {
            mMinDistance = minDistance;
            requestLocation();
        }

    }

    public int getMinDistance() {
        return mMinDistance;
    }

    public void setProvider(String provider) throws ProviderIsNotEnabledException {
        if (!provider.equals(getProvider())) {
            mProvider = provider;
            requestLocation();
        }


    }

    public String getProvider() {
        return mProvider;
    }


    private boolean isBetterLocation(Location location, Location currentBestLocation) {
        if (currentBestLocation == null) {
            // A new location is always better than no location
            return true;
        }

        // Check whether the new location fix is newer or older
        long timeDelta = location.getTime() - currentBestLocation.getTime();
        boolean isSignificantlyNewer = timeDelta > getMinTime();
        boolean isSignificantlyOlder = timeDelta < -getMinTime();
        boolean isNewer = timeDelta > 0;

        // If it's been more than two minutes since the current location, use the new location
        // because the user has likely moved
        if (isSignificantlyNewer) {
            return true;
            // If the new location is more than two minutes older, it must be worse
        } else if (isSignificantlyOlder) {
            return false;
        }

        // Check whether the new location fix is more or less accurate
        int accuracyDelta = (int) (location.getAccuracy() - currentBestLocation.getAccuracy());
        boolean isLessAccurate = accuracyDelta > 0;
        boolean isMoreAccurate = accuracyDelta < 0;
        boolean isSignificantlyLessAccurate = accuracyDelta > 200;

        // Check if the old and new location are from the same provider
        boolean isFromSameProvider = isSameProvider(location.getProvider(), currentBestLocation.getProvider());

        // Determine location quality using a combination of timeliness and accuracy
        if (isMoreAccurate) {
            return true;
        } else if (isNewer && !isLessAccurate) {
            return true;
        } else if (isNewer && !isSignificantlyLessAccurate && isFromSameProvider) {
            return true;
        }
        return false;
    }

    /** Checks whether two providers are the same */
    private boolean isSameProvider(String provider1, String provider2) {
        if (provider1 == null) {
            return provider2 == null;
        }
        return provider1.equals(provider2);
    }


    public class ProviderIsNotEnabledException extends Exception {
        public ProviderIsNotEnabledException(String errorMessage) {
            super(errorMessage);
        }
    }


}
