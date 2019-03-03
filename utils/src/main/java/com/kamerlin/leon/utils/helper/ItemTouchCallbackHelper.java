package com.kamerlin.leon.utils.helper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;

import com.kamerlin.leon.utils.library.R;
import com.kamerlin.leon.utils.mjolnir.MjolnirRecyclerAdapter;
import com.kamerlin.leon.utils.mjolnir.MjolnirViewHolder;
import com.kamerlin.leon.utils.mjolnir.RecyclerViewItemTouchListener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class ItemTouchCallbackHelper extends ItemTouchHelper.Callback {
    private final Context context;
    private RecyclerViewItemTouchListener recyclerViewItemTouchListener;
    private int dragFlags;
    private int swipeFlags;
    private boolean enableLongPressDrag;
    private boolean enableItemViewSwipe;


    public ItemTouchCallbackHelper(Context context) {
        this.context = context;
        Activity activity = (Activity) context;
        if (activity instanceof RecyclerViewItemTouchListener) {
            recyclerViewItemTouchListener = (RecyclerViewItemTouchListener) activity;
        }


        setDragFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN);
        setSwipeFlags(ItemTouchHelper.START | ItemTouchHelper.END);
        enableItemViewSwipe(true);
        enableLongPressDrag(true);
    }

    public ItemTouchCallbackHelper(Context context, RecyclerViewItemTouchListener recyclerViewItemTouchListener) {
        this(context);
        this.recyclerViewItemTouchListener = recyclerViewItemTouchListener;
    }


    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        if (recyclerView.getAdapter() instanceof MjolnirRecyclerAdapter) {
            MjolnirRecyclerAdapter mjolnirRecyclerAdapter = (MjolnirRecyclerAdapter) recyclerView.getAdapter();
            if(mjolnirRecyclerAdapter.isHeader(viewHolder.getAdapterPosition()) || mjolnirRecyclerAdapter.isFooter(viewHolder.getAdapterPosition())) return 0;

        }

        return ItemTouchHelper.Callback.makeMovementFlags(dragFlags, swipeFlags);
    }



    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

            MjolnirViewHolder mjolnirViewHolder = (MjolnirViewHolder)viewHolder;

            if (mjolnirViewHolder.hasBackgroundView()) {
                View backgroundView = mjolnirViewHolder.backgroundView;

                Rect rect = new Rect();
                rect.set(mjolnirViewHolder.itemView.getLeft(), mjolnirViewHolder.itemView.getTop(), mjolnirViewHolder.itemView.getRight(), mjolnirViewHolder.itemView.getBottom());


                //Measure the view at the exact dimensions (otherwise the text won't center correctly)
                int widthSpec = View.MeasureSpec.makeMeasureSpec(rect.width(), View.MeasureSpec.EXACTLY);
                int heightSpec = View.MeasureSpec.makeMeasureSpec(rect.height(), View.MeasureSpec.EXACTLY);
                backgroundView.measure(widthSpec, heightSpec);

                //Lay the view out at the rect width and height
                backgroundView.layout(0, 0, rect.width(), rect.height());


                //Translate the Canvas into position and draw it
                c.save();
                c.translate(rect.left, rect.top);
                backgroundView.draw(c);
                c.restore();
            }



            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        } else if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }

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



    public void setDragFlags(int flag) {
        this.dragFlags = flag;
    }

    public void setSwipeFlags(int flag) {
        this.swipeFlags = flag;
    }

    public void enableLongPressDrag(boolean enable) {
        this.enableLongPressDrag = enable;
    }

    public void enableItemViewSwipe(boolean enable) {
        enableItemViewSwipe = enable;
    }





    
}
