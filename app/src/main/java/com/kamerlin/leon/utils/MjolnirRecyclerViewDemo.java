package com.kamerlin.leon.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.kamerlin.leon.utils.common.ItemTouchCallback;
import com.kamerlin.leon.utils.mjolnir.MjolnirRecyclerView;


public class MjolnirRecyclerViewDemo extends AppCompatActivity implements SimpleAdapter.StartDrag {

    private MjolnirRecyclerView mRecyclerView;
    private SimpleAdapter mAdapter;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mjolnir_recycler_view);
        mRecyclerView = findViewById(R.id.recycler_view);
        mAdapter = new SimpleAdapter(this);
        setupRecyclerView();
        setupAdapter();
    }

    private void setupRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setEmptyView(findViewById(R.id.empty_view));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setupAdapter() {

        populateRecyclerView();

        //mAdapter.setHeader(R.layout.view_header);
        //mAdapter.setFooter(R.layout.view_footer);
        mAdapter.setItemColor(Color.MAGENTA);


        ItemTouchCallback swipeToDeleteCallback = new ItemTouchCallback.Builder(this)
                .setListener(mAdapter)
                .setBackgroundColor(Color.GREEN)
                .setLeftIcon(R.drawable.ic_delete_white_24)
                .setRightIcon(R.drawable.ic_delete_white_24)
                .enableItemViewSwipe(true)
                .enableLongPressDrag(true)
                .build();


        itemTouchHelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);




    }

    private void populateRecyclerView() {
        mAdapter.add("1");
        mAdapter.add("2");
        mAdapter.add("3");
        mAdapter.add("4");
        mAdapter.add("5");
        mAdapter.add("6");
    }

    @Override
    public void onDrag(RecyclerView.ViewHolder viewHolder) {
        Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
        itemTouchHelper.startDrag(viewHolder);
    }
}
