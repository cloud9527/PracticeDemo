package com.example.cloud.mypriatice.customerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Cloud on 2017/2/8.
 */

public class CircleProgressView extends View {

    private int with;
    private int height;

    private float mSweepAngle;
    private float mSweepValue = 66;
    private RectF mArcRectF;
    private Paint mCirclePaint;
    private float mRadius;
    private float mCircleXY;
    private Paint mArcPaint;
    private Paint mTextPaint;


    public CircleProgressView(Context context) {
        super(context);
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e("TAG", "onSizeChanged");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("TAG", "onMeasure");
        with = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(with, height);
        initView();
    }

    private void initView() {
        float length = 0;
        if (height >= with) {
            length = with;
        } else {
            length = height;
        }

        mCircleXY = length / 2;
        mRadius = (float) (length * 0.5 / 2);
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);//抗锯齿
        mCirclePaint.setColor(Color.YELLOW);
        mArcRectF = new RectF(
                (float) (length * 0.1),
                (float) (length * 0.1),
                (float) (length * 0.9),
                (float) (length * 0.9));

        mSweepAngle = (mSweepValue / 100f) * 360f;

        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setColor(Color.GRAY);
        mArcPaint.setStrokeWidth((float) (length * 0.1));
        mArcPaint.setStyle(Paint.Style.STROKE);


        mTextPaint = new Paint();
        mTextPaint.setColor(Color.MAGENTA);
        mTextPaint.setTextSize(100);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    private String mShowText = "我是TEXT";

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.e("TAG", "onFinishInflate");
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.e("TAG", "onAttachedToWindow");
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
        Log.e("TAG", "layout");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e("TAG", "onLayout");
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Log.e("TAG", "draw");
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e("TAG", "onDraw");
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        canvas.drawArc(mArcRectF, 0, 90, false, mArcPaint);
        canvas.drawText(mShowText, 0, mShowText.length(), mCircleXY, mCircleXY + (100 / 4), mTextPaint);
    }
}
