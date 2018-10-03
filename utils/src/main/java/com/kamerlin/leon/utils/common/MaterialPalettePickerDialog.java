package com.kamerlin.leon.utils.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.flexbox.FlexboxLayout;
import com.kamerlin.leon.utils.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;
import com.kamerlin.leon.utils.materialpallete.MaterialColorFactory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MaterialPalettePickerDialog extends DialogFragment {
    private int mCurrentActive;
    private String mColorName;
    private MaterialPaletteSelector mMaterialPaletteSelector;

    public MaterialPalettePickerDialog() {

    }



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        if (getActivity() instanceof MaterialPaletteSelector) {
            mMaterialPaletteSelector = (MaterialPaletteSelector)getActivity();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.material_palette, null);
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
                            ColorIcon previus = (ColorIcon) rootLayout.getChildAt(mCurrentActive);
                            previus.setActive(false);
                            current.setActive(true);
                            mCurrentActive = id;
                            mColorName = current.getColorName();

                            if (mMaterialPaletteSelector != null) {
                                mMaterialPaletteSelector.onColorChange(MaterialColorFactory.getColor(mColorName), mColorName);
                            }
                        }


                    }
                });
            }
        }

        builder.setView(view)
                .setTitle("Material Palette Color")
                // Add action buttons
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if (mMaterialPaletteSelector != null) {
                            mMaterialPaletteSelector.onColorSelected(MaterialColorFactory.getColor(mColorName), mColorName);
                        }
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


    public interface MaterialPaletteSelector {
        void onColorChange(MaterialColor materialColor, String colorName);
        void onColorSelected(MaterialColor materialColor, String colorName);
    }
}
