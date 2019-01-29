package com.kamerlin.leon.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.kamerlin.leon.utils.mjolnir.ActionModeRecyclerViewAdapter;
import com.kamerlin.leon.utils.mjolnir.MjolnirViewHolder;

import java.util.Collections;


public class SimpleAdapter extends ActionModeRecyclerViewAdapter<String> {
    private StartDrag mStartDrag;
    public SimpleAdapter(Context context) {
        super(context, Collections.emptyList());
        Activity activity = (Activity)context;
        if (activity instanceof StartDrag) {
            mStartDrag = (StartDrag) activity;
        }
    }

    @Override
    protected ActionModeRecyclerViewAdapter.ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_adapter, parent, false);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MjolnirViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        MyViewHolder viewHolder = (MyViewHolder)holder;

    }

    class MyViewHolder extends ActionModeRecyclerViewAdapter<String>.ItemViewHolder {
        TextView tvPosition;
        TextView tvText;
        View rootView;
        ImageView iconMove;

        @SuppressLint("ClickableViewAccessibility")
        public MyViewHolder(View itemView) {
            super(itemView);
            tvPosition = itemView.findViewById(R.id.tv_position);
            tvText = itemView.findViewById(R.id.tv_text);
            rootView = itemView.findViewById(R.id.root_view);
            iconMove = itemView.findViewById(R.id.iconMove);

            iconMove.setOnTouchListener((v, event) -> {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    mStartDrag.onDrag(this);
                }
                return false;
            });

        }

        @Override
        protected void bind(String item, int position) {
            super.bind(item, position);
            tvPosition.setText(String.valueOf(position).concat("."));
            tvText.setText(item);
        }



    }

    interface StartDrag {
        void onDrag(RecyclerView.ViewHolder viewHolder);
    }

}
