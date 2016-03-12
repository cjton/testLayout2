package com.example.tangj.testlayout2;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by tangj on 2016/2/28.
 */
public class MyGroup extends ViewGroup {

    public MyGroup(Context context) {
        super(context);
    }

    public MyGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    private  final static int padding = 20;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureWidth = measureWidth(widthMeasureSpec);
       // Log.i("Onlayout group", Integer.toString(measureWidth));
        int measureHeight = measureHeight(heightMeasureSpec);
        setMeasuredDimension(measureWidth,measureHeight);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }
    private int measureWidth(int pWidthMeasureSpec){
        int result = 0;
        int widthMode = MeasureSpec.getMode(pWidthMeasureSpec);
        int widthSize = MeasureSpec.getSize(pWidthMeasureSpec);
        switch (widthMode) {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.EXACTLY:
                result = widthSize;
                break;
        }
        return result;
    }
    private int measureHeight(int pHeightMeasureSpec){
        int result = 0;
        int heightMode = MeasureSpec.getMode(pHeightMeasureSpec);
        int heightSize = MeasureSpec.getSize(pHeightMeasureSpec);
        switch (heightMode) {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.EXACTLY:
                result = heightSize;
        }
        return result;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {


        for (int i = 0, size = getChildCount(); i < size; i++)
        {
            View view = getChildAt(i);
            int measureWidth = view.getMeasuredWidth();
            int measureHeight = view.getMeasuredHeight();
//            Log.i("OnLayout",Integer.toString(measureHeight));
//            Log.i("OnLayout", Integer.toString(measureWidth));
            view.layout(l, t, l+ measureWidth, t + measureHeight );
            l += 200 + padding;
        }
    }
}
