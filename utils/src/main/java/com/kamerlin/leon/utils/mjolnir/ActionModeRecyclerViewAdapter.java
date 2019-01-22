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
    public ActionMode.Callback  provideDefaultActionModeCallbacks() {

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
                removeAll(selectedItems);
                mode.finish();

                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

                selectedItems.clear();
                notifyDataSetChanged();
                mActionMode = null;
            }
        };
    }

    protected ActionMode mActionMode;
    protected boolean isActionModeActive() {
        return mActionMode != null;
    }


    protected ActionMode.Callback actionModeCallbacks;

    public void setActionModelCallBacks(ActionMode.Callback actionModeCallbacks) {
        this.actionModeCallbacks = actionModeCallbacks;
    }

    public ActionModeRecyclerViewAdapter(Context context, Collection<E> list) {
        super(context, list);
        setActionModelCallBacks(provideDefaultActionModeCallbacks());
    }


    public abstract class ItemViewHolder extends MjolnirViewHolder<E> {



        public ItemViewHolder(View itemView) {
            super(itemView);
        }

        void selectItem(E item) {
            if (isActionModeActive()) {
                if (selectedItems.contains(item)) {
                    selectedItems.remove(item);
                    itemView.setBackgroundColor(Color.WHITE);
                } else {
                    selectedItems.add(item);
                    itemView.setBackgroundColor(Color.LTGRAY);
                }

                updateCount();
            }
        }

        @Override
        protected void bind(E item, int position) {
            itemView.setBackgroundColor(Color.WHITE);
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onClick(position, item);
                }
                selectItem(item);
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (actionModeCallbacks == null) return false;
                    mActionMode = ((AppCompatActivity) view.getContext()).startSupportActionMode(actionModeCallbacks);
                    selectItem(item);
                    updateCount();
                    return true;
                }
            });
        }

        private void updateCount() {
            if (mActionMode == null) return;
            mActionMode.setTitle("Count: "+selectedItems.size());
            mActionMode.invalidate();
        }
    }


}
