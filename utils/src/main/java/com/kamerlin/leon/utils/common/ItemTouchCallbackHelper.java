package com.kamerlin.leon.utils.common;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.kamerlin.leon.utils.library.R;
import com.kamerlin.leon.utils.mjolnir.RecyclerViewItemTouchListener;

public abstract class ItemTouchCallbackHelper extends ItemTouchHelper.Callback {
    protected final Context context;
    protected RecyclerViewItemTouchListener recyclerViewItemTouchListener;
    protected Drawable leftIcon, rightIcon;
    protected ColorDrawable background;
    protected int dragFlags;
    protected int swipeFlags;
    private int backgroundColor;
    private boolean enableLongPressDrag;
    private boolean enableItemViewSwipe;

    public ItemTouchCallbackHelper(ItemTouchCallback.Builder builder) {
        this.context = builder.context;


        setBackgroundColor(builder.backgroundColor);
        setLeftIcon(builder.leftIcon);
        setRightIcon(builder.rightIcon);
        setListener(builder.listener);
        setDragFlags(builder.dragFlags);
        setSwipeFlags(builder.swipeFlags);
        enableLongPressDrag(builder.enableLongPressDrag);
        enableItemViewSwipe(builder.enableItemViewSwipe);
        background = new ColorDrawable();
    }

    private void enableItemViewSwipe(boolean enableItemViewSwipe) {
        this.enableItemViewSwipe = enableItemViewSwipe;
    }

    private void enableLongPressDrag(boolean enableLongPressDrag) {
        this.enableLongPressDrag = enableLongPressDrag;
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
        return enableLongPressDrag;
    }



    @Override
    public boolean isItemViewSwipeEnabled() {
        return enableItemViewSwipe;
    }

    private void setBackgroundColor(int color) {
        backgroundColor = color;
    }

    public int getBackgroundColor() {
        if (backgroundColor == 0) {
            return R.color.design_default_color_primary;
        }
        return backgroundColor;
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

    public void setDragFlags(int enabled) {
        this.dragFlags = enabled;
    }

    public void setSwipeFlags(int swipeFlags) {
        this.swipeFlags = swipeFlags;
    }


    
}
