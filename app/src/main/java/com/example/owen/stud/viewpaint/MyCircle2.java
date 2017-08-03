package com.example.owen.stud.viewpaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.owen.stud.R;

/**
 * Created by loopeer on 2017/7/25.
 */

public class MyCircle2 extends View {

    Paint mPaint = new Paint();
    private float progress = 0f;//0f中间,1f左边，2f右边
    private int mDirect = 0;

    public MyCircle2(Context context) {
        super(context);
    }

    public MyCircle2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCircle2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int verticalCenter = getHeight() / 2;
        int horizontalCenter = getWidth() / 2;
        int circleRadius = 200;

        mPaint.setColor(getResources().getColor(R.color.pink));
        mPaint.setStrokeWidth(25);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(horizontalCenter, verticalCenter - 250, circleRadius, mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(horizontalCenter, verticalCenter - 250, 160, mPaint);//参数分别是圆心的水平边距、竖直边距、半径

        if (progress == 0f) {
            mPaint.setColor(Color.WHITE);
            //两个长方形
            canvas.drawRect((horizontalCenter - (160 / 3) - 10), (verticalCenter - 250 - (160 / 3) - 20), (horizontalCenter - (160 / 3) + 10), (verticalCenter - 250 - (160 / 3) + 20), mPaint);
            canvas.drawRect((horizontalCenter + (160 / 3) - 10), (verticalCenter - 250 - (160 / 3) - 20), (horizontalCenter + (160 / 3) + 10), (verticalCenter - 250 - (160 / 3) + 20), mPaint);

            //四个小圆形在长方形短边上
            canvas.drawCircle(horizontalCenter - (160 / 3), (verticalCenter - 250 - (160 / 3) - 20), 10, mPaint);
            canvas.drawCircle(horizontalCenter - (160 / 3), (verticalCenter - 250 - (160 / 3) + 20), 10, mPaint);
            canvas.drawCircle(horizontalCenter + (160 / 3), (verticalCenter - 250 - (160 / 3) - 20), 10, mPaint);
            canvas.drawCircle(horizontalCenter + (160 / 3), (verticalCenter - 250 - (160 / 3) + 20), 10, mPaint);
        } else if (progress == 1f) {
            mPaint.setColor(Color.WHITE);
            canvas.drawRect((horizontalCenter - 2 * (160 / 3) - 10), (verticalCenter - 250 - (160 / 3) - 20), (horizontalCenter - 2 * (160 / 3) + 10), (verticalCenter - 250 - (160 / 3) + 20), mPaint);
            canvas.drawRect((horizontalCenter - 10), (verticalCenter - 250 - (160 / 3) - 20), (horizontalCenter + 10), (verticalCenter - 250 - (160 / 3) + 20), mPaint);

            canvas.drawCircle(horizontalCenter - 2 * (160 / 3), (verticalCenter - 250 - (160 / 3) - 20), 10, mPaint);
            canvas.drawCircle(horizontalCenter - 2 * (160 / 3), (verticalCenter - 250 - (160 / 3) + 20), 10, mPaint);
            canvas.drawCircle(horizontalCenter, (verticalCenter - 250 - (160 / 3) - 20), 10, mPaint);
            canvas.drawCircle(horizontalCenter, (verticalCenter - 250 - (160 / 3) + 20), 10, mPaint);
        } else if (progress == 2f) {
            mPaint.setColor(Color.WHITE);
            canvas.drawRect(horizontalCenter-10, (verticalCenter - 250 - (160 / 3) - 20), (horizontalCenter + 10), (verticalCenter - 250 - (160 / 3) + 20), mPaint);
            canvas.drawRect((horizontalCenter + 2 * (160 / 3) - 10), (verticalCenter - 250 - (160 / 3) - 20), (horizontalCenter + 2 * (160 / 3) + 10), (verticalCenter - 250 - (160 / 3) + 20), mPaint);

            canvas.drawCircle(horizontalCenter, (verticalCenter - 250 - (160 / 3) - 20), 10, mPaint);
            canvas.drawCircle(horizontalCenter, (verticalCenter - 250 - (160 / 3) + 20), 10, mPaint);
            canvas.drawCircle(horizontalCenter + 2 * (160 / 3), (verticalCenter - 250 - (160 / 3) - 20), 10, mPaint);
            canvas.drawCircle(horizontalCenter + 2 * (160 / 3), (verticalCenter - 250 - (160 / 3) + 20), 10, mPaint);
        }
        invalidate();

    }

    /*@Override
    public void invalidate() {
        super.invalidate();
    }*/

    public void eyesDirect(int direct) {
        switch (direct) {
            case 0:
                progress = 0f;
                break;
            case 1:
                progress = 1f;
                break;
            case 2:
                progress = 2f;
                break;
            default:
        }

    }


    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
