package com.kamerlin.leon.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kamerlin.leon.utils.mjolnir.ActionModeRecyclerViewAdapter;

import java.util.Collections;



public class SimpleAdapter extends ActionModeRecyclerViewAdapter<String> {

    public SimpleAdapter(Context context) {
        super(context, Collections.emptyList());
    }

    @Override
    protected ActionModeRecyclerViewAdapter.ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_adapter, parent, false);
        return new MyViewHolder(rootView);
    }


    class MyViewHolder extends ActionModeRecyclerViewAdapter<String>.ItemViewHolder {
        TextView tvPosition;
        TextView tvText;
        View rootView;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvPosition = itemView.findViewById(R.id.tv_position);
            tvText = itemView.findViewById(R.id.tv_text);
            rootView = itemView.findViewById(R.id.root_view);

        }

        @Override
        protected void bind(String item, int position) {
            super.bind(item, position);
            tvPosition.setText(String.valueOf(position).concat("."));
            tvText.setText(item);
        }


    }



    @Override
    public String getTitle(int count) {
        return "Hello: "+ count;
    }
}
