package com.example.cloud.mypriatice.customerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Scroller;

/**
 * Created by Cloud on 2017/2/9.
 */

public class MyScrollView extends ViewGroup {

    private int mHeightPixels;
    private Scroller mScroller;

    public MyScrollView(Context context) {
        super(context);
        initView(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    private void initView(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        mHeightPixels = displayMetrics.heightPixels;
        mScroller = new Scroller(context);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int childCount = getChildCount();
        Log.e("TAG","onLayout");
        MarginLayoutParams layoutParams = (MarginLayoutParams) getLayoutParams();
        layoutParams.height = childCount * mHeightPixels;
        setLayoutParams(layoutParams);
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != GONE) {
                childAt.layout(left, i * mHeightPixels, right, (i + 1) * mHeightPixels);
            }

        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("TAG","onMeasure");
        int childCount = getChildCount();
        for (int i = 0; i < childCount; ++i) {
            View childAt = getChildAt(i);
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
        }
    }

    int lastY;
    private int mStart;
    private int mEnd;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastY = y;
                mStart = getScrollY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (!mScroller.isFinished()) mScroller.abortAnimation();

                int dy = lastY - y;
                if (getScrollY() < 0) {
                    dy = 0;
                }
                if (getScrollY() > getHeight() - mHeightPixels) {
                    dy = 0;
                }
                scrollBy(0, dy);
                lastY = y;
                break;
            case MotionEvent.ACTION_UP:
                mEnd = getScrollY();
                int distanceY = mEnd - mStart;
                if (distanceY > 0) {
                    if (distanceY < mHeightPixels / 3) {
                        mScroller.startScroll(0, getScrollY(), 0, -distanceY);
                    } else {
                        mScroller.startScroll(0, getScrollY(), 0, mHeightPixels - distanceY);
                    }
                } else {
                    if (-distanceY < mHeightPixels / 3) {
                        mScroller.startScroll(0, getScrollY(), 0, -distanceY);
                    } else {
                        mScroller.startScroll(0, getScrollY(), 0, -mHeightPixels - distanceY);
                    }
                }
                break;
        }
        postInvalidate();
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        Log.e("TAG","computeScroll");
        if (mScroller.computeScrollOffset()) {
            scrollTo(0, mScroller.getCurrY());
            postInvalidate();
        }
    }
}
