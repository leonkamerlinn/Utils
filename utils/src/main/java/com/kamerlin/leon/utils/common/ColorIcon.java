package com.kamerlin.leon.utils.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.kamerlin.leon.utils.R;
import com.kamerlin.leon.utils.materialpallete.MaterialColor;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

public class ColorIcon extends LinearLayoutCompat {
    private View mView;
    private LinearLayoutCompat mLinearLayoutCompat;
    private ConstraintLayout mRootLayout;
    private String mName;

    public ColorIcon(Context context) {
        super(context);
        init(null);
    }

    public ColorIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ColorIcon(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        mView = inflate(getContext(), R.layout.color_icon, this);
        mLinearLayoutCompat = mView.findViewById(R.id.smallCircle);
        mRootLayout = mView.findViewById(R.id.rootLayout);
        if (attrs == null)return;
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.ColorIcon);
        boolean active = ta.getBoolean(R.styleable.ColorIcon_active, false);
        ta.recycle();
        setActive(active);
    }

    public void setColor(MaterialColor color) {
        Drawable drawable = mRootLayout.getBackground();
        drawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getContext(), color.get500()), PorterDuff.Mode.SRC));
    }

    public void setActive(boolean active) {
        mLinearLayoutCompat.setVisibility((active) ? View.VISIBLE : View.INVISIBLE);
    }

    public void setColorName(String name) {
        mName = name;
    }

    public String getColorName() {
        return mName;
    }
}
