package com.example.cloud.mypriatice.customerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Cloud on 2017/4/19.
 */

public class RaderView extends View {
    private int count = 6;                //数据个数
    private float angle = (float) (Math.PI * 2 / count);
    private float radius;                   //网格最大半径
    private int centerX;                  //中心X
    private int centerY;                  //中心Y
    private String[] titles = {"a", "b", "c", "d", "e", "f"};
    private double[] data = {66, 60, 88, 60, 33, 50, 10, 20}; //各维度分值
    private float maxValue = 100;             //数据最大值
    private Paint mainPaint;                //雷达区画笔
    private Paint valuePaint;               //数据区画笔
    private Paint textPaint;                //文本画笔

    public RaderView(Context context) {
        super(context);
        initData();
    }


    public RaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    private void initData() {
        mainPaint = new Paint();
        mainPaint.setStrokeWidth(1);
        mainPaint.setAntiAlias(true);
        mainPaint.setStyle(Paint.Style.STROKE);
        mainPaint.setColor(Color.BLACK);

        textPaint = new Paint();
        textPaint.setStrokeWidth(1);
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.RED);
        textPaint.setTextSize(30);

        valuePaint = new Paint();
        valuePaint.setStrokeWidth(1);
        valuePaint.setAntiAlias(true);
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        valuePaint.setColor(Color.BLUE);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        radius = Math.min(w, h) / 2 * 0.8f;
        centerX = w / 2;
        centerY = h / 2;
        postInvalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawPolygon(canvas);
        drarLines(canvas);
        drawTexts(canvas);
        drawRegion(canvas);
    }

    /**
     * 绘制多边形
     *
     * @param canvas
     */
    private void drawPolygon(Canvas canvas) {
        Path path = new Path();
        float r = radius / (count - 1);
        for (int i = 0; i < count; i++) {
            float curR = r * i;
            path.reset();
            for (int j = 0; j < count; j++) {
                if (j == 0) {
                    path.moveTo(centerX + curR, centerY);
                } else {
                    //根据半径，计算出蜘蛛丝上每个点的坐标
                    float x = (float) (centerX + curR * Math.cos(angle * j));
                    float y = (float) (centerY + curR * Math.sin(angle * j));
                    path.lineTo(x, y);
                }
            }
            path.close();
            canvas.drawPath(path, mainPaint);
        }
    }

    private void drarLines(Canvas canvas) {
        Path path = new Path();
        for (int i = 0; i < count; i++) {
            path.reset();
            path.moveTo(centerX, centerY);
            float x = (float) (centerX + radius * Math.cos(angle * i));
            float y = (float) (centerY + radius * Math.sin(angle * i));

            path.lineTo(x, y);
            canvas.drawPath(path, mainPaint);
        }
    }

    private void drawTexts(Canvas canvas) {
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float fontHeight = fontMetrics.descent - fontMetrics.ascent;
        for (int i = 0; i < count; i++) {
            float x = (float) (centerX + (radius + fontHeight / 2) * Math.cos(angle * i));
            float y = (float) (centerY + (radius + fontHeight / 2) * Math.sin(angle * i));
            if (angle * i >= 0 && angle * i <= Math.PI / 2) {//第4象限
                canvas.drawText(titles[i], x, y, textPaint);
            } else if (angle * i >= 3 * Math.PI / 2 && angle * i <= Math.PI * 2) {//第3象限
                canvas.drawText(titles[i], x, y, textPaint);
            } else if (angle * i > Math.PI / 2 && angle * i <= Math.PI) {//第2象限
                float dis = textPaint.measureText(titles[i]);//文本长度
                canvas.drawText(titles[i], x - dis, y, textPaint);
            } else if (angle * i >= Math.PI && angle * i < 3 * Math.PI / 2) {//第1象限
                float dis = textPaint.measureText(titles[i]);//文本长度
                canvas.drawText(titles[i], x - dis, y, textPaint);
            }
        }
    }

    private void drawRegion(Canvas canvas) {
        Path path = new Path();
        valuePaint.setAlpha(255);
        for (int i = 0; i < count; i++) {
            double percent = data[i] / maxValue;
            float x = (float) (centerX + radius * Math.cos(angle * i) * percent);
            float y = (float) (centerY + radius * Math.sin(angle * i) * percent);
            if (i == 0) {
                path.moveTo(x, y);
            } else {
                path.lineTo(x, y);
            }
            canvas.drawCircle(x, y, 10, valuePaint);
        }
        valuePaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, valuePaint);
        valuePaint.setAlpha(127);

        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path, valuePaint);
    }
}
