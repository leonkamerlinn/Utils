package com.kamerlin.leon.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.kamerlin.leon.utils.helper.ItemTouchCallbackHelper;
import com.kamerlin.leon.utils.mjolnir.MjolnirRecyclerAdapter;
import com.kamerlin.leon.utils.mjolnir.MjolnirRecyclerView;


public class MjolnirRecyclerViewDemo extends AppCompatActivity {

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
       // mAdapter.setItemColor(Color.MAGENTA);


        ItemTouchCallbackHelper itemTouchCallbackHelper = new ItemTouchCallbackHelper(this, mAdapter);




        itemTouchHelper = new ItemTouchHelper(itemTouchCallbackHelper);
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

}
