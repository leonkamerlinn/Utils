package com.kamerlin.leon.utils.common;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.kamerlin.leon.utils.mjolnir.RecyclerViewItemTouchListener;

public abstract class ItemTouchCallbackHelper extends ItemTouchHelper.Callback {
    protected final Context context;
    protected RecyclerViewItemTouchListener recyclerViewItemTouchListener;
    protected Drawable leftIcon, rightIcon;
    protected ColorDrawable background;
    protected int backgroundColor;

    public ItemTouchCallbackHelper(ItemTouchCallback.Builder builder) {
        this.context = builder.context;
        setBackgroundColor(builder.backgroundColor);
        setLeftIcon(builder.leftIcon);
        setRightIcon(builder.rightIcon);
        setListener(builder.listener);
        background = new ColorDrawable();
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int position = viewHolder.getAdapterPosition();
        recyclerViewItemTouchListener.onItemDismiss(position);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        if (viewHolder.getItemViewType() != viewHolder1.getItemViewType()) {
            return false;
        }

        int from = viewHolder.getAdapterPosition();
        int to = viewHolder1.getAdapterPosition();
        recyclerViewItemTouchListener.onItemMove(from, to);
        return true;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    private void setBackgroundColor(int color) {
        backgroundColor = color;
    }

    private void setListener(RecyclerViewItemTouchListener listener) {
        this.recyclerViewItemTouchListener = listener;
    }


    private void setLeftIcon(Drawable drawable) {
        leftIcon = drawable;
    }


    private void setRightIcon(Drawable drawable) {
        rightIcon = drawable;
    }



}
