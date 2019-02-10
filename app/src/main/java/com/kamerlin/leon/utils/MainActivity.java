package com.kamerlin.leon.utils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;
import com.kamerlin.leon.utils.dialog.MaterialPalettePickerFragmentDialog;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private String mTitle;
    private String mColorName;
    private TextInputEditText mTextInputEditText;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.listView);
        populateAndSetupListView();
    }

    private void populateAndSetupListView() {
        // populate ListView
        String[] data = new String[] {
                "Material Color Picker",
                "Mjolnir RecyclerView"
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
