package com.kamerlin.leon.utils.common;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import com.kamerlin.leon.utils.R;
import com.kamerlin.leon.utils.mjolnir.RecyclerViewItemTouchHelper;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ItemTouchHelperCallbackHelper extends ItemTouchHelper.Callback {
    protected final Context context;
    protected final RecyclerViewItemTouchHelper recyclerViewItemTouchHelper;
    protected Drawable deleteIcon;
    protected int intrinsicWidth;
    protected int intrinsicHeight;
    protected ColorDrawable background;
    protected int backgroundColor;

    public ItemTouchHelperCallbackHelper(Context context, RecyclerViewItemTouchHelper recyclerViewItemTouchHelper) {
        this.context = context;
        this.recyclerViewItemTouchHelper = recyclerViewItemTouchHelper;

        deleteIcon = ContextCompat.getDrawable(context, R.drawable.ic_delete_white_24);
        intrinsicWidth = deleteIcon.getIntrinsicWidth();
        intrinsicHeight = deleteIcon.getIntrinsicHeight();
        background = new ColorDrawable();
        backgroundColor = Color.BLUE;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int position = viewHolder.getAdapterPosition();
        recyclerViewItemTouchHelper.onItemDismiss(position);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        if (viewHolder.getItemViewType() != viewHolder1.getItemViewType()) {
            return false;
        }

        int from = viewHolder.getAdapterPosition();
        int to = viewHolder1.getAdapterPosition();
        recyclerViewItemTouchHelper.onItemMove(from, to);
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
}
