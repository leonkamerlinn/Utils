package com.kamerlin.leon.utils.mjolnir;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public abstract class MjolnirViewHolder<E> extends RecyclerView.ViewHolder {

    public MjolnirViewHolder(View itemView) {
        super(itemView);
    }

    protected abstract void bind(E item, int position);
}

