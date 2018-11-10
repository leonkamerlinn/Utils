package com.kamerlin.leon.utils.mjolnir;

public interface RecyclerViewItemTouchHelper {
    void onItemDismiss(int position);
    void onItemMove(int fromPosition, int toPosition);
}
