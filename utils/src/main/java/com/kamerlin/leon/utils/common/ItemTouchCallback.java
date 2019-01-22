package com.kamerlin.leon.utils.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.kamerlin.leon.utils.mjolnir.MjolnirRecyclerAdapter;
import com.kamerlin.leon.utils.mjolnir.RecyclerViewItemTouchListener;

public class ItemTouchCallback extends ItemTouchCallbackHelper {

    public ItemTouchCallback(Builder builder) {
        super(builder);
    }
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        if (recyclerView.getAdapter() instanceof MjolnirRecyclerAdapter) {
            MjolnirRecyclerAdapter mjolnirRecyclerAdapter = (MjolnirRecyclerAdapter) recyclerView.getAdapter();
            if(mjolnirRecyclerAdapter.isHeader(viewHolder.getAdapterPosition()) || mjolnirRecyclerAdapter.isFooter(viewHolder.getAdapterPosition())) return 0;

        }

        int dragFlags = dragEnabled ? ItemTouchHelper.UP | ItemTouchHelper.DOWN : 0;
        int swipeFlags = swipEnabled ? ItemTouchHelper.START | ItemTouchHelper.END : 0;
        return ItemTouchHelper.Callback.makeMovementFlags(dragFlags, swipeFlags);
    }





    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        View itemView = viewHolder.itemView;
        int itemHeight = itemView.getBottom() - itemView.getTop();

        // Calculate position of delete icon
        int iconMargin = (itemHeight - leftIcon.getIntrinsicHeight()) / 2;

        int topRectBound = itemView.getTop() + (itemHeight - leftIcon.getIntrinsicHeight()) / 2;
        int leftRectBound, rightRectBound;

        // Draw the red delete background
        background.setColor(getBackgroundColor());
        if (dX >= 0) {
            // swiping right,  dX is positive
            background.setBounds(itemView.getLeft(), itemView.getTop(), itemView.getLeft() + (int)dX, itemView.getBottom());
            // for left icon
            leftRectBound = itemView.getLeft() + iconMargin;
            rightRectBound = itemView.getLeft() + iconMargin + leftIcon.getIntrinsicWidth();
        } else {
            // swiping left, dX is negative
            background.setBounds(itemView.getRight() + (int)dX, itemView.getTop(), itemView.getRight(), itemView.getBottom());
            // for right icon
            leftRectBound = itemView.getRight() - iconMargin - leftIcon.getIntrinsicWidth();
            rightRectBound = itemView.getRight() - iconMargin;
        }
        background.draw(c);

        int bottomRectBound = topRectBound + leftIcon.getIntrinsicHeight();

        // Draw the delete icon
        leftIcon.setBounds(leftRectBound, topRectBound, rightRectBound, bottomRectBound);
        leftIcon.draw(c);



        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }


    public static class Builder {
        public int backgroundColor;
        public final Context context;
        public RecyclerViewItemTouchListener listener;
        public Drawable leftIcon, rightIcon;
        public boolean dragEnabled = false, swipeEnabled = true;


        public Builder(Context context) {
            this.context = context;
        }

        public Builder setBackgroundColor(int color) {
            this.backgroundColor = color;
            return this;
        }

        public Builder setListener(RecyclerViewItemTouchListener listener) {
            this.listener = listener;
            return this;
        }

        public Builder setLeftIcon(Drawable drawable) {
            this.leftIcon = drawable;
            return this;
        }

        public Builder setLeftIcon(@DrawableRes int drawableRes) {
            return setLeftIcon(ContextCompat.getDrawable(context, drawableRes));
        }

        public Builder setRightIcon(@DrawableRes int drawableRes) {
            return setRightIcon(ContextCompat.getDrawable(context, drawableRes));
        }

        public Builder setRightIcon(Drawable drawable) {
            this.rightIcon = drawable;
            return this;
        }

        public Builder enableDrag(boolean enabled) {
            this.dragEnabled = enabled;
            return this;
        }

        public Builder enableSwip(boolean enabled) {
            this.swipeEnabled = enabled;
            return this;
        }

        public ItemTouchCallback build() {
            return new ItemTouchCallback(this);
        }
    }


}
