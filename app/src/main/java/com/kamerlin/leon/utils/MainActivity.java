package com.kamerlin.leon.utils;

import android.os.Bundle;

import com.kamerlin.leon.utils.common.MaterialPalettePickerDialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showNoticeDialog();
    }


    public void showNoticeDialog() {
        // Create an instance of the dialog fragment and show it
        DialogFragment dialog = new MaterialPalettePickerDialog();
        dialog.show(getSupportFragmentManager(), "NoticeDialogFragment");
    }


}
