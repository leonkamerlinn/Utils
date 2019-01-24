package com.kamerlin.leon.utils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kamerlin.leon.utils.common.MaterialPalettePickerDialog;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;


public class MainActivity extends AppCompatActivity {

    private ListView mListView;

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

    private void showMaterialColorPicker() {
        // show material color picker
        MaterialPalettePickerDialog dialog = new MaterialPalettePickerDialog.Builder()
                .setMaterialPaletteListener(new MaterialPalettePickerDialog.MaterialPaletteListener() {
                    @Override
                    public void onColorChanged(MaterialColor materialColor, String colorName) {

                        Toast.makeText(MainActivity.this, "Color Changed: " + colorName, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onColorSelected(MaterialColor materialColor, String colorName) {
                        System.out.println(colorName);
                        Toast.makeText(MainActivity.this, "Color Selected: " + colorName, Toast.LENGTH_SHORT).show();
                    }
                })
                .showTextInputEditText(true)
                .build();


        dialog.show(getSupportFragmentManager(), MaterialPalettePickerDialog.TAG);



    }




}
