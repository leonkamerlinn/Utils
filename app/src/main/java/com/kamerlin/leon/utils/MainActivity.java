package com.kamerlin.leon.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.kamerlin.leon.utils.common.MaterialPalettePickerDialog;
import com.kamerlin.leon.utils.common.SwipeToDeleteCallback;
import com.kamerlin.leon.utils.mjolnir.MjolnirRecyclerView;
import com.tbruyelle.rxpermissions2.RxPermissions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;


public class MainActivity extends AppCompatActivity {

    private MjolnirRecyclerView recyclerView;
    private SimpleAdapter adapter;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setEmptyView(findViewById(R.id.empty_view));





        adapter = new SimpleAdapter(this);
        adapter.add("1");
        adapter.add("2");
        adapter.add("3");
        adapter.add("4");
        adapter.add("5");
        adapter.add("6");
        adapter.setHeader(R.layout.view_header);

        adapter.setOnClickListener((index, item) -> Toast.makeText(this, item, Toast.LENGTH_SHORT).show());

        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(this, adapter);


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        //adapter.setHeader(R.layout.view_header);
        //adapter.setFooter(R.layout.view_footer);

        recyclerView.setAdapter(adapter);
    }

    @SuppressLint("CheckResult")
    private void rx_permission() {
        final RxPermissions rxPermissions = new RxPermissions(this);


        rxPermissions
                .requestEach(Manifest.permission.CAMERA)
                .subscribe(permission -> {
                    if (permission.granted) {
                        Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
                    } else {


                        Toast.makeText(this, "Not granted", Toast.LENGTH_SHORT).show();


                    }
                });

        rxPermissions.isRevoked(Manifest.permission.CALL_PHONE);
    }


    public void showNoticeDialog() {
        // Create an instance of the dialog fragment and show it
        DialogFragment dialog = new MaterialPalettePickerDialog();
        dialog.show(getSupportFragmentManager(), "NoticeDialogFragment");
    }


}
