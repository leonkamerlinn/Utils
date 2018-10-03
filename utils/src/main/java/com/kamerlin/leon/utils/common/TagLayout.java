package com.kamerlin.leon.utils.common;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.LinearLayout;

/**
 * Created by Leon on 19.2.2018..
 */

public class TagLayout extends LinearLayout {
    private static final String TAG = TagLayout.class.getSimpleName();

    int deviceWidth;


    public TagLayout(Context context) {
        this(context, null, 0);
    }

    public TagLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TagLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        final Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point deviceDisplay = new Point();
        display.getSize(deviceDisplay);
        deviceWidth = deviceDisplay.x;

    }



    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

        boolean newRow;
        final int rootLeft = getPaddingLeft();
        final int rootRight = getMeasuredWidth() - getPaddingRight();

        final int rootWidth = getMeasuredWidth() - (getPaddingLeft() + getPaddingRight());
        final int rootHeight = getMeasuredHeight() - (getPaddingTop() + getPaddingBottom());

        final int rootTop = getPaddingTop();
        final int rootBottom = getMeasuredHeight() - getPaddingBottom();


        int currentLeft = rootLeft;
        int currentTop = rootTop;

        int childWidth, childHeight;
        int previusMarginTop = 0;
        int previusMarginBottom = 0;
        int countRow = 0;

        for (int x = 0; x < getChildCount(); x++) {
            View child = getChildAt(x);
            if (child.getVisibility() == GONE) return;

            if (child instanceof CheckBox) {
                CheckBox checkBox = (CheckBox)child;


            }

            child.measure(MeasureSpec.makeMeasureSpec(rootWidth, MeasureSpec.AT_MOST), MeasureSpec.makeMeasureSpec(rootHeight, MeasureSpec.AT_MOST));
            childWidth = child.getMeasuredWidth();
            childHeight = child.getMeasuredHeight();
            LinearLayout.LayoutParams lp = (LayoutParams) child.getLayoutParams();
            currentLeft += lp.leftMargin;



            currentTop -= previusMarginTop;
            currentTop += lp.topMargin;
            previusMarginTop = lp.topMargin;


            if (countRow == 0 && x == 0) {
                // first row
                currentTop += 20;
            }

            if (currentLeft + childWidth > rootRight) {
                // new row
                newRow = true;
                countRow++;
                currentLeft = rootLeft;
                currentTop += childHeight;
                currentTop += 20;
            } else {
                newRow = false;
            }

            if (countRow > 0) {

                if (newRow) {
                    currentLeft += lp.leftMargin;
                } else {
                    currentTop -= previusMarginBottom;
                }

                currentTop += lp.bottomMargin;
                previusMarginBottom = lp.bottomMargin;
            }

            currentLeft += 20;

            //do the layout
            child.layout(currentLeft, currentTop, currentLeft + childWidth, currentTop + childHeight);
            //store the max height

            currentLeft += childWidth;
            currentLeft += lp.rightMargin;
        }
    }




    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        // Measurement will ultimately be computing these values.
        int maxHeight = 0;
        int maxWidth = 0;

        int childState = 0;
        int sumWidth = 0;
        int maxChildHeight = 0;



        /*

        //Measure Width
       if (widthMode == MeasureSpec.EXACTLY) {
           //Must be this size
           System.out.println("EXACTLY");
       } else if (widthMode == MeasureSpec.AT_MOST) {
           //Can't be bigger than...
           System.out.println("AT_MOST");
       } else {
           //Be whatever you want
           System.out.println("else");
       }*/

        // Iterate through all children, measuring them and computing our dimensions
        // from their size.
        for (int i = 0; i < getChildCount(); i++) {
            final View child = getChildAt(i);

            if (child.getVisibility() == GONE)
                continue;




            // Measure the child.
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            LinearLayout.LayoutParams lp = (LayoutParams) child.getLayoutParams();
            sumWidth += (child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin);
            maxWidth = Math.max(sumWidth, maxWidth);


            maxChildHeight = Math.max(maxChildHeight, child.getMeasuredHeight() + lp.bottomMargin + lp.topMargin);




            if (sumWidth > deviceWidth) {
                maxHeight += maxChildHeight;
                sumWidth = 0;
                maxChildHeight = 0;

            } else {
                maxHeight = Math.max(maxHeight, child.getMeasuredHeight());
            }

            childState = combineMeasuredStates(childState, child.getMeasuredState());
        }

        maxHeight += maxChildHeight;



        // Check against our minimum height and width
        maxHeight = Math.max(maxHeight, getSuggestedMinimumHeight());

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        maxWidth = widthSize;
        // Report our final dimensions.
        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, childState), resolveSizeAndState(maxHeight, heightMeasureSpec, childState << MEASURED_HEIGHT_STATE_SHIFT));
    }


    private int measureDimension(int desiredSize, int measureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = desiredSize;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }

        if (result < desiredSize){
            Log.e(TAG, "The view is too small, the content might get cut");
        }
        return result;
    }


}