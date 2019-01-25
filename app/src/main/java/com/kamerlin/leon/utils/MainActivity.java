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

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function3;
import io.reactivex.schedulers.Schedulers;


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

    private void onError(MaterialPalettePickerDialog dialog) {

    }

    @SuppressLint("CheckResult")
    private void showMaterialColorPicker() {
        // show material color picker
        MaterialPalettePickerDialog dialog = new MaterialPalettePickerDialog.Builder()
                .showTextInputEditText(true)
                .build();


        dialog.show(getSupportFragmentManager(), MaterialPalettePickerDialog.TAG);



        Observable.combineLatest(
                dialog.getColorNameObservable().lastOrError().toObservable(),
                dialog.getTitleObservable().lastOrError().toObservable(),
                dialog.getPositiveButtonClickObservable().lastOrError().toObservable(),
                new Function3<String, String, Boolean, String[]>() {
                    @Override
                    public String[] apply(String s, String s2, Boolean aBoolean) {
                        return new String[] {s, s2};
                    }
                }
        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(System.out::println, System.err::println);


    }




}
