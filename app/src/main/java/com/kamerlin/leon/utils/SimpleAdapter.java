package com.kamerlin.leon.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kamerlin.leon.utils.mjolnir.MjolnirRecyclerAdapter;

import java.util.Collections;


public class SimpleAdapter extends MjolnirRecyclerAdapter<String> {

    public SimpleAdapter(Context context) {
        super(context, Collections.emptyList());
    }

    @Override
    protected MyViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_adapter, parent, false);
        View backgroundView = LayoutInflater.from(getContext()).inflate(R.layout.remove_item, null, false);
        MyViewHolder viewHolder = new MyViewHolder(rootView, backgroundView);

        return viewHolder;
    }





    @Override
    public void setOnClickListener(OnClickListener<String> listener) {
        super.setOnClickListener(listener);
    }

    private class MyViewHolder extends ItemViewHolder {




        @SuppressLint("ClickableViewAccessibility")
        public MyViewHolder(View itemView, View bacgroundView) {
            super(itemView, bacgroundView);




        }


        @SuppressLint("ClickableViewAccessibility")
        @Override
        protected void bind(String item, int position) {
            super.bind(item, position);


        }



    }



}
