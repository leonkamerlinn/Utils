package com.kamerlin.leon.utils.common;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.DialogFragment;

import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.kamerlin.leon.utils.library.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;
import com.kamerlin.leon.utils.materialpallete.MaterialColorFactory;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;

public class MaterialPalettePickerDialog extends DialogFragment {
    public static final String TAG = MaterialPalettePickerDialog.class.getSimpleName();



    private int mCurrentActive;
    private String mTitle, mPositiveButtonText, mNegativeButtonText, mColorName;
    private boolean mShowTextInputEditText;
    private final ReplaySubject<TextInputEditText> mTextInputEditTextReplaySubject;
    private final ReplaySubject<String> mColorNameReplaySubject;
    private final ReplaySubject<Boolean> mPositiveButtonClickedReplaySubject;
    private final ReplaySubject<Boolean> mNegativeButtonClickedReplaySubject;
    private final ReplaySubject<String> mTitleReplaySubject;


    @SuppressLint("CheckResult")
    private MaterialPalettePickerDialog() {
        mTitle = "Material Palette Colors";
        mPositiveButtonText = "Ok";
        mNegativeButtonText = "Cancel";
        mShowTextInputEditText = false;

        mTextInputEditTextReplaySubject = ReplaySubject.create();
        mTitleReplaySubject = ReplaySubject.create();
        mColorNameReplaySubject = ReplaySubject.create();
        mPositiveButtonClickedReplaySubject = ReplaySubject.create();
        mNegativeButtonClickedReplaySubject = ReplaySubject.create();
    }


    public Observable<TextInputEditText> getTextInputEditTextObservable() {
        return mTextInputEditTextReplaySubject
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<String> getColorNameObservable() {
        return mColorNameReplaySubject
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
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

    public Observable<String> getTitleObservable() {
        return mTitleReplaySubject
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    private void setTitle(String title) {
        if (title == null) return;
        mTitle = title;
    }

    private void setPositiveButtonText(String text) {
        if (text == null) return;
        mPositiveButtonText = text;
    }

    private void setNegativeButtonText(String text) {
        if (text == null) return;
        mNegativeButtonText = text;
    }

    private void showTextInputEditText(boolean show) {
        mShowTextInputEditText = show;
    }

    private static MaterialPalettePickerDialog newInstance() {
        MaterialPalettePickerDialog dialog = new MaterialPalettePickerDialog();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        dialog.setArguments(args);

        return dialog;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        setRetainInstance(true);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.material_palette, null);

        TextInputLayout textInputLayout = view.findViewById(R.id.textInputLayout);
        TextInputEditText textInputEditText = view.findViewById(R.id.textInputEditText);

        mTextInputEditTextReplaySubject.onNext(textInputEditText);
        mTextInputEditTextReplaySubject.onComplete();

        ScrollView scrollView = view.findViewById(R.id.scrollView);
        ConstraintLayout constraintLayout = view.findViewById(R.id.constraintLayout);

        if (!mShowTextInputEditText) {
            textInputLayout.setVisibility(View.INVISIBLE);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);
            constraintSet.clear(scrollView.getId(), ConstraintSet.TOP);

            constraintSet.applyTo(constraintLayout);
        } else {
            textInputEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    mTitleReplaySubject.onNext(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
        FlexboxLayout rootLayout = view.findViewById(R.id.rootLayout);
        for (int i = 0; i < rootLayout.getChildCount(); i++) {
            if (rootLayout.getChildAt(i) instanceof ColorIcon) {
                ColorIcon colorIcon = (ColorIcon) rootLayout.getChildAt(i);
                String colorName = MaterialColor.getOrderdColors()[i];
                colorIcon.setColor(MaterialColorFactory.getColor(colorName));
                colorIcon.setId(i);
                colorIcon.setColorName(colorName);

                if (i == 0) {
                    colorIcon.setActive(true);
                    mCurrentActive = 0;
                    mColorName = colorIcon.getColorName();
                    mColorNameReplaySubject.onNext(mColorName);
                }


                colorIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int id = v.getId();
                        if (id == mCurrentActive)return;

                        if (v instanceof ColorIcon) {
                            ColorIcon current = (ColorIcon)v;
                            ColorIcon previous = (ColorIcon) rootLayout.getChildAt(mCurrentActive);
                            previous.setActive(false);
                            current.setActive(true);
                            mCurrentActive = id;
                            mColorName = current.getColorName();
                            mColorNameReplaySubject.onNext(mColorName);
                        }
                    }
                });
            }
        }




        builder.setView(view)
                .setTitle(mTitle)
                // Add action buttons
                .setPositiveButton(mPositiveButtonText, null)
                .setNegativeButton(mNegativeButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        negativeButtonClick();
                    }
                });





        return builder.create();
    }

    private void negativeButtonClick() {
        mNegativeButtonClickedReplaySubject.onNext(true);
    }

    private void positiveButtonClick() {
        mPositiveButtonClickedReplaySubject.onNext(true);
    }



    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {

            int orientation = getResources().getConfiguration().orientation;
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                // In landscape
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            } else {
                // In portrait
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        }



        getDialog().setCanceledOnTouchOutside(false);

        AlertDialog d = (AlertDialog)getDialog();
        if(d != null) {
            Button positiveButton = (Button) d.getButton(Dialog.BUTTON_POSITIVE);
            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    positiveButtonClick();
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






    public static class Builder {
        private String title;

        private String positiveButtonText;
        private String negativeButtonText;
        private boolean showTextInputEditText;

        public Builder() {
            showTextInputEditText = false;
        }


        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setPositiveButtonText(String text) {
            this.positiveButtonText = text;
            return this;
        }

        public Builder setNegativeButtonText(String text) {
            this.negativeButtonText = text;
            return this;
        }


        public Builder showTextInputEditText(boolean showTextInputEditText) {
            this.showTextInputEditText = showTextInputEditText;
            return this;
        }

        public MaterialPalettePickerDialog build() {
            MaterialPalettePickerDialog dialog = MaterialPalettePickerDialog.newInstance();

            dialog.setTitle(title);
            dialog.setNegativeButtonText(negativeButtonText);
            dialog.setPositiveButtonText(positiveButtonText);
            dialog.showTextInputEditText(showTextInputEditText);
            return dialog;
        }

    }
}
