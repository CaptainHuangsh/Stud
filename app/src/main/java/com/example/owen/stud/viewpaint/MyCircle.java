package com.example.owen.stud.viewPaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.owen.stud.R;
import com.example.owen.stud.viewPager.ViewPagerActivity;

/**
 * Created by loopeer on 2017/7/25.
 */

public class MyCircle extends View {

    Paint mPaint = new Paint();
    private float progress = 0f;

    public MyCircle(Context context) {
        super(context);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        canvas.drawCircle(horizontalCenter, verticalCenter - 250, 160, mPaint);

        if (progress == 0f) {
            mPaint.setColor(Color.WHITE);
            canvas.drawRect((horizontalCenter - (160 / 3) - 10), (verticalCenter - 250 - (160 / 3) - 20), (horizontalCenter - (160 / 3) + 10), (verticalCenter - 250 - (160 / 3) + 20), mPaint);
            canvas.drawRect((horizontalCenter + (160 / 3) - 10), (verticalCenter - 250 - (160 / 3) - 20), (horizontalCenter + (160 / 3) + 10), (verticalCenter - 250 - (160 / 3) + 20), mPaint);

            canvas.drawCircle(horizontalCenter - (160 / 3), (verticalCenter - 250 - (160 / 3) - 20), 10, mPaint);
            canvas.drawCircle(horizontalCenter - (160 / 3), (verticalCenter - 250 - (160 / 3) + 20), 10, mPaint);
            canvas.drawCircle(horizontalCenter + (160 / 3), (verticalCenter - 250 - (160 / 3) - 20), 10, mPaint);
            canvas.drawCircle(horizontalCenter + (160 / 3), (verticalCenter - 250 - (160 / 3) + 20), 10, mPaint);
            this.postInvalidateDelayed(3000);    // 延时3000ms
            progress = 1f;
//            invalidate();
        } else {
            mPaint.setColor(Color.BLACK);
            canvas.drawRect((horizontalCenter - (160 / 3) - 10), (verticalCenter - 250 - (160 / 3) - 3), (horizontalCenter - (160 / 3) + 10), (verticalCenter - 250 - (160 / 3) + 3), mPaint);
            canvas.drawRect((horizontalCenter + (160 / 3) - 10), (verticalCenter - 250 - (160 / 3) - 3), (horizontalCenter + (160 / 3) + 10), (verticalCenter - 250 - (160 / 3) + 3), mPaint);
            this.postInvalidateDelayed(300);    // 延时300ms
            progress = 0f;

        }

    }

    /*@Override
    public void invalidate() {
        super.invalidate();
    }*/

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
