package com.kamerlin.leon.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;
import com.kamerlin.leon.utils.dialog.MaterialPalettePickerFragmentDialog;
import com.kamerlin.leon.utils.helper.RxLocation;
import com.tbruyelle.rxpermissions2.RxPermissions;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private String mTitle;
    private String mColorName;
    private TextInputEditText mTextInputEditText;

    private RxLocation mRxLocation;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.listView);
        populateAndSetupListView();



        mRxLocation = RxLocation.getInstance(this);
        mRxLocation.getLocationObservable()
                .map(Location::getLatitude)
                .subscribe(System.out::println);

        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.requestEach(Manifest.permission.ACCESS_FINE_LOCATION).subscribe(permission -> {
            if (permission.name.equals(Manifest.permission.ACCESS_FINE_LOCATION)) {
                if (permission.granted) {
                    try {
                        mRxLocation.setProvider(LocationManager.GPS_PROVIDER);
                        mRxLocation.setMinTime(10000);
                        mRxLocation.start();
                    } catch (RxLocation.ProviderIsNotEnabledException e) {
                        e.printStackTrace();
                        buildAlertMessageNoGps();
                    }
                }
            } else if (permission.shouldShowRequestPermissionRationale) {
                buildAlertMessageNoGps();
            }
        });



    }


    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    private void populateAndSetupListView() {
        // populate ListView
        String[] data = new String[] {
                "Material Color Picker",
                "Mjolnir RecyclerView",
                "Canvas"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        showMaterialColorPicker();
                        break;

                    case 1:
                        showMjolnirRecyclerView();
                        break;

                    case 2:
                        Intent intent = new Intent(MainActivity.this, CanvasDrawing.class);
                        startActivity(intent);
                    break;
                }
            }
        });
    }

    private void showMjolnirRecyclerView() {
        Intent intent = new Intent(this, MjolnirRecyclerViewDemo.class);
        startActivity(intent);
    }



    @SuppressLint("CheckResult")
    private void showMaterialColorPicker() {


        // show material color picker
        MaterialPalettePickerFragmentDialog dialog = new MaterialPalettePickerFragmentDialog.Builder()
                .showTextInputEditText(true)
                .build();



        dialog.show(getSupportFragmentManager(), MaterialPalettePickerFragmentDialog.TAG);



        dialog.getTitleObservable().subscribe(s -> mTitle = s);

        dialog.getColorNameObservable().subscribe(s -> mColorName = s);
        dialog.getTextInputEditTextObservable().subscribe(textInputEditText -> mTextInputEditText = textInputEditText);

        dialog.getPositiveButtonClickObservable().subscribe(aBoolean -> {
            if (mTitle == null) {
                mTextInputEditText.setError("Title is required");
            } else {
                dialog.dismiss();
                mTitle = null;
            }
        });

        dialog.getNegativeButtonClickObservable().subscribe(aBoolean -> {
            dialog.dismiss();
        });



    }




}
