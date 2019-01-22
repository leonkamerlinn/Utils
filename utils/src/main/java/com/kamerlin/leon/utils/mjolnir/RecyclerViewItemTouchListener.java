package com.kamerlin.leon.utils.mjolnir;

public interface RecyclerViewItemTouchListener {
    void onItemDismiss(int position);
    void onItemMove(int fromPosition, int toPosition);
}
