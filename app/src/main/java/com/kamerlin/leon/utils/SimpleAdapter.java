package com.kamerlin.leon.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kamerlin.leon.utils.mjolnir.MjolnirRecyclerAdapter;

import java.util.Collections;
import java.util.List;


/**
 * Created by Željko Plesac on 27/09/16.
 */
public class SimpleAdapter extends MjolnirRecyclerAdapter<String> {

    public SimpleAdapter(Context context) {
        super(context, Collections.emptyList());
    }

    @Override
    protected MjolnirViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_adapter, parent, false);
        return new TestViewHolder(rootView);
    }


    class TestViewHolder extends MjolnirRecyclerAdapter<String>.MjolnirViewHolder<String> {
        TextView tvPosition;
        TextView tvText;
        View rootView;

        public TestViewHolder(View itemView) {
            super(itemView);
            tvPosition = itemView.findViewById(R.id.tv_position);
            tvText = itemView.findViewById(R.id.tv_text);
            rootView = itemView.findViewById(R.id.root_view);
        }

        @Override
        protected void bind(String item, int position, List<Object> payloads) {
            super.bind(item, position, payloads);
            tvPosition.setText(String.valueOf(position).concat("."));
            tvText.setText(item);
        }
    }



}
