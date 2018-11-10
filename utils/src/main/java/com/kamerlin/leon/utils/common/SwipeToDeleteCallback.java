package com.kamerlin.leon.utils.common;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.kamerlin.leon.utils.mjolnir.RecyclerViewItemTouchHelper;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SwipeToDeleteCallback extends ItemTouchHelperCallbackHelper {

    public SwipeToDeleteCallback(Context context, RecyclerViewItemTouchHelper recyclerViewItemTouchHelper) {
        super(context, recyclerViewItemTouchHelper);
    }
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {

        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return ItemTouchHelper.Callback.makeMovementFlags(dragFlags, swipeFlags);
    }





    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        View itemView = viewHolder.itemView;
        int itemHeight = itemView.getBottom() - itemView.getTop();

        // Draw the red delete background
        background.setColor(backgroundColor);
        if (dX >= 0) {
            // swiping right,  dX is positive
            background.setBounds(itemView.getLeft(), itemView.getTop(), itemView.getLeft() + (int)dX, itemView.getBottom());
        } else {
            // swiping left, dX is negative
            background.setBounds(itemView.getRight() + (int)dX, itemView.getTop(), itemView.getRight(), itemView.getBottom());
        }
        background.draw(c);



        // Calculate position of delete icon
        int deleteIconTop = itemView.getTop() + (itemHeight - intrinsicHeight) / 2;
        int deleteIconMargin = (itemHeight - intrinsicHeight) / 2;
        int deleteIconLeft = itemView.getRight() - deleteIconMargin - intrinsicWidth;
        int deleteIconRight = itemView.getRight() - deleteIconMargin;
        int deleteIconBottom = deleteIconTop + intrinsicHeight;

        // Draw the delete icon
        deleteIcon.setBounds(deleteIconLeft, deleteIconTop, deleteIconRight, deleteIconBottom);
        deleteIcon.draw(c);



        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }


}
