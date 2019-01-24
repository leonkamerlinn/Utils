package com.kamerlin.leon.utils.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class MaterialPalettePickerDialog extends DialogFragment {
    public static final String TAG = MaterialPalettePickerDialog.class.getSimpleName();

    private int mCurrentActive;
    private MaterialPaletteListener mMaterialPaletteListener;
    private String mTitle, mPositiveButtonText, mNegativeButtonText, mColorName;
    private boolean mShowTextInputEditTextt;
    private TextInputEditText mTextInputEditText;


    private MaterialPalettePickerDialog() {
        mTitle = "Material Palette Colors";
        mPositiveButtonText = "Ok";
        mNegativeButtonText = "Cancel";
        mShowTextInputEditTextt = false;
    }


    public TextInputEditText getTextInputEditText() {
        return mTextInputEditText;
    }


    private synchronized void setMaterialPaletteListener(MaterialPaletteListener materialPaletteListener) {
        if (mMaterialPaletteListener == null && materialPaletteListener != null) {
            mMaterialPaletteListener = materialPaletteListener;
        }
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
        mShowTextInputEditTextt = show;
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

        if (getActivity() instanceof MaterialPaletteListener) {
            mMaterialPaletteListener = (MaterialPaletteListener)getActivity();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.material_palette, null);

        TextInputLayout textInputLayout = view.findViewById(R.id.textInputLayout);
        mTextInputEditText = view.findViewById(R.id.textInputEditText);
        ScrollView scrollView = view.findViewById(R.id.scrollView);
        ConstraintLayout constraintLayout = view.findViewById(R.id.constraintLayout);

        if (!mShowTextInputEditTextt) {
            textInputLayout.setVisibility(View.INVISIBLE);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);
            constraintSet.clear(scrollView.getId(), ConstraintSet.TOP);

            constraintSet.applyTo(constraintLayout);
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

                            if (mMaterialPaletteListener != null) {
                                mMaterialPaletteListener.onColorChanged(MaterialColorFactory.getColor(mColorName), mColorName);
                            }
                        }


                    }
                });
            }
        }




        builder.setView(view)
                .setTitle(mTitle)
                // Add action buttons
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        mMaterialPaletteListener.onColorSelected(MaterialColorFactory.getColor(mColorName), mColorName);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MaterialPalettePickerDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            int valueInPixels = (int) getResources().getDimension(R.dimen.icon_width);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        }
    }


    public interface MaterialPaletteListener {
        void onColorChanged(MaterialColor materialColor, String colorName);
        void onColorSelected(MaterialColor materialColor, String colorName);
    }



    public static class Builder {
        private String title;
        private MaterialPaletteListener materialPaletteListener;
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

        public Builder setMaterialPaletteListener(MaterialPaletteListener materialPaletteListener) {
            this.materialPaletteListener = materialPaletteListener;
            return this;
        }

        public Builder showTextInputEditText(boolean showTextInputEditText) {
            this.showTextInputEditText = showTextInputEditText;
            return this;
        }

        public MaterialPalettePickerDialog build() {
            MaterialPalettePickerDialog dialog = MaterialPalettePickerDialog.newInstance();
            dialog.setMaterialPaletteListener(materialPaletteListener);
            dialog.setTitle(title);
            dialog.setNegativeButtonText(negativeButtonText);
            dialog.setPositiveButtonText(positiveButtonText);
            dialog.showTextInputEditText(showTextInputEditText);
            return dialog;
        }

    }
}
