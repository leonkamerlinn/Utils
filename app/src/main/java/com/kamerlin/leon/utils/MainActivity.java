package com.kamerlin.leon.utils;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.kamerlin.leon.utils.common.ItemTouchCallback;
import com.kamerlin.leon.utils.common.MaterialPalettePickerDialog;
import com.kamerlin.leon.utils.mjolnir.MjolnirRecyclerView;


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
        adapter.setFooter(R.layout.view_footer);


        ItemTouchCallback swipeToDeleteCallback = new ItemTouchCallback.Builder(this)
                .setListener(adapter)
                .setBackgroundColor(Color.RED)
                .setLeftIcon(R.drawable.ic_delete_white_24)
                .setRightIcon(R.drawable.ic_delete_white_24)
                .build();


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);





        recyclerView.setAdapter(adapter);
    }




    public void showNoticeDialog() {
        // Create an instance of the dialog fragment and show it
        DialogFragment dialog = new MaterialPalettePickerDialog();
        dialog.show(getSupportFragmentManager(), "NoticeDialogFragment");
    }


}
