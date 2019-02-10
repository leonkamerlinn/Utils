package com.kamerlin.leon.utils.utils;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class BindingAdapters {
    @BindingAdapter("showView")
    public static void showView(View view, boolean show) {
        if (show) {
            if (view.getVisibility() == View.GONE || view.getVisibility() == View.INVISIBLE) {
                view.setVisibility(View.VISIBLE);
            }
        } else {
            if (view.getVisibility() == View.VISIBLE) {
                view.setVisibility(View.GONE);
            }
        }
    }

    @BindingAdapter("hideView")
    public static void hideView(View view, boolean hide) {
        showView(view, !hide);
    }

    @BindingAdapter("setCategoryColor")
    public static void setCategoryColor(ImageView imageView, String categoryName) {

    }


    @BindingAdapter("setDateTime")
    public static void setDateTime(TextView textView, long unix) {
        if (unix == -1) return;

        DateFormat format = new SimpleDateFormat("yyyy/MM/dd @ HH:mm", Locale.getDefault());
        textView.setText(format.format(new Date(unix)));
    }



    @BindingAdapter("setAdapter")
    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("setLayoutManager")
    public static void setLayoutManager(RecyclerView recyclerView, RecyclerView.LayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager);
    }


}
