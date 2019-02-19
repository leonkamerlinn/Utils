package com.kamerlin.leon.utils.utils;

import android.app.Dialog;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import dagger.android.DaggerDialogFragment;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;

public abstract class DaggerDialogFragmentCancelable extends DaggerDialogFragment {
    private final ReplaySubject<Boolean> mPositiveButtonClickedReplaySubject, mNegativeButtonClickedReplaySubject;


    public DaggerDialogFragmentCancelable() {
        mPositiveButtonClickedReplaySubject = ReplaySubject.create();
        mNegativeButtonClickedReplaySubject = ReplaySubject.create();
    }

    @Override
    public void onStart() {
        super.onStart();

        getDialog().setCanceledOnTouchOutside(false);

        AlertDialog d = (AlertDialog)getDialog();
        if(d != null) {
            Button positiveButton = d.getButton(Dialog.BUTTON_POSITIVE);
            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    positiveButtonClick();
                }
            });

            Button negativeButton = d.getButton(Dialog.BUTTON_NEGATIVE);
            negativeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    negativeButtonClick();
                }
            });
        }
    }


    @Override
    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    private void negativeButtonClick() {
        mNegativeButtonClickedReplaySubject.onNext(true);
    }

    private void positiveButtonClick() {
        mPositiveButtonClickedReplaySubject.onNext(true);
    }

    public Observable<Boolean> getPositiveButtonClickObservable() {
        return mPositiveButtonClickedReplaySubject
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Boolean> getNegativeButtonClickObservable() {
        return mNegativeButtonClickedReplaySubject
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
