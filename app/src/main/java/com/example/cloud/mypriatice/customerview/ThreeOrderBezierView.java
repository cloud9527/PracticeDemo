package com.example.cloud.mypriatice.customerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 三节贝塞尔曲线
 * Created by Cloud on 2017/4/19.
 */

public class ThreeOrderBezierView extends View {

    private Paint mPaint;
    private PointF mStart;
    private PointF mEnd;
    private PointF mControl1;
    private PointF mControl2;
    private int mCenterX;
    private int mCenterY;
    private boolean mode = true;

    public ThreeOrderBezierView(Context context) {
        super(context);
        initData();

    }

    public ThreeOrderBezierView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    private void initData() {
        mPaint = new Paint();
        mPaint.setTextSize(60);
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(8);
        mPaint.setStyle(Paint.Style.STROKE);

        mStart = new PointF(0, 0);
        mEnd = new PointF(0, 0);
        mControl1 = new PointF(0, 0);
        mControl2 = new PointF(0, 0);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mCenterX = w / 2;
        mCenterY = h / 2;

        // 初始化数据点和控制点的位置
        mStart.x = mCenterX - 200;
        mStart.y = mCenterY;
        mEnd.x = mCenterX + 200;
        mEnd.y = mCenterY;
        mControl1.x = mCenterX - 200;
        mControl1.y = mCenterY - 500;
        mControl2.x = mCenterX + 200;
        mControl2.y = mCenterY - 250;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(20);
        canvas.drawPoint(mStart.x, mStart.y, mPaint);
        canvas.drawPoint(mEnd.x, mEnd.y, mPaint);
        canvas.drawPoint(mControl1.x, mControl1.y, mPaint);
        canvas.drawPoint(mControl2.x, mControl2.y, mPaint);

        mPaint.setStrokeWidth(4);
        canvas.drawLine(mStart.x, mStart.y, mControl1.x, mControl1.y, mPaint);
        canvas.drawLine(mControl1.x, mControl1.y, mControl2.x, mControl2.y, mPaint);
        canvas.drawLine(mControl2.x, mControl2.y, mEnd.x, mEnd.y, mPaint);

        mPaint.setColor(Color.YELLOW);
        mPaint.setStrokeWidth(8);
        Path path = new Path();
        path.moveTo(mStart.x, mStart.y);
        path.cubicTo(mControl1.x, mControl1.y, mControl2.x, mControl2.y, mEnd.x, mEnd.y);
        canvas.drawPath(path, mPaint);
    }

    public void setMode(boolean mode) {
        this.mode = mode;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mode) {
            mControl1.x = event.getX();
            mControl1.y = event.getY();
        } else {
            mControl2.x = event.getX();
            mControl2.y = event.getY();
        }
        invalidate();
        return true;
    }
}
