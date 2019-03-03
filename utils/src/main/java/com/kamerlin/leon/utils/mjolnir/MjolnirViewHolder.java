package com.kamerlin.leon.utils.mjolnir;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public abstract class MjolnirViewHolder<E> extends RecyclerView.ViewHolder {

    public View backgroundView;

    public boolean hasBackgroundView() {
        return backgroundView != null;
    }

    public MjolnirViewHolder(View itemView) {
        super(itemView);
    }

    public MjolnirViewHolder(View foregroundView, View backgroundView) {
        this(foregroundView);
        this.backgroundView = backgroundView;
    }



    public void setBackgroundView(View backgroundView) {
        this.backgroundView = backgroundView;
    }

    protected abstract void bind(E item, int position);
}

