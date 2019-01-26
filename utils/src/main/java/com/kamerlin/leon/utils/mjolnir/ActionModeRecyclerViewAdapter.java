package com.kamerlin.leon.utils.mjolnir;

import android.content.Context;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

import com.kamerlin.leon.utils.library.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class ActionModeRecyclerViewAdapter<E> extends MjolnirRecyclerAdapter<E> {

    protected List<E> selectedItems = new ArrayList<>();
    protected ActionMode actionMode;
    private int mHighlightItemColor;
    private int mItemColor;



    @Override
    public void onBindViewHolder(MjolnirViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
    }

    protected boolean isActionModeActive() {
        return actionMode != null;
    }
    protected ActionMode.Callback actionModeCallbacks;


    protected ActionMode.Callback  provideDefaultActionModeCallbacks() {

        return new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.context_menu, menu);

                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.delete) {
                    removeAll(selectedItems);
                }

                mode.finish();

                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

                selectedItems.clear();
                notifyDataSetChanged();
                actionMode = null;
            }
        };
    }


    private void setActionModelCallBacks(ActionMode.Callback actionModeCallbacks) {
        this.actionModeCallbacks = actionModeCallbacks;
    }

    public ActionModeRecyclerViewAdapter(Context context, Collection<E> list) {
        super(context, list);
        setHighlightItemColor(Color.LTGRAY);
        setItemColor(Color.WHITE);
        setActionModelCallBacks(provideDefaultActionModeCallbacks());
    }

    public void setHighlightItemColor(int color) {
        mHighlightItemColor = color;
    }

    public void setItemColor(int color) {
        mItemColor = color;
    }


    public abstract class ItemViewHolder extends MjolnirViewHolder<E> {


        public ItemViewHolder(View itemView) {
            super(itemView);
        }

        void selectItem(E item) {
            if (isActionModeActive()) {
                if (selectedItems.contains(item)) {
                    selectedItems.remove(item);
                    itemView.setBackgroundColor(mItemColor);
                } else {
                    selectedItems.add(item);
                    itemView.setBackgroundColor(mHighlightItemColor);
                }
                if (selectedItems.size() == 0) {
                    actionMode.finish();
                    return;
                }
                updateCount();
            }
        }

        @Override
        protected void bind(E item, int position) {
            itemView.setBackgroundColor(mItemColor);
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onClick(position, item);
                }
                selectItem(item);
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (actionModeCallbacks == null || isActionModeActive()) return false;
                    actionMode = ((AppCompatActivity) view.getContext()).startSupportActionMode(actionModeCallbacks);
                    selectItem(item);
                    return true;
                }
            });
        }

        private void updateCount() {
            if (actionMode == null || getTitle(selectedItems.size()) == null) return;
            actionMode.setTitle(getTitle(selectedItems.size()));
            actionMode.invalidate();
        }
    }

    public String getTitle(int count) {
        return "Count: "+count;
    }


}
