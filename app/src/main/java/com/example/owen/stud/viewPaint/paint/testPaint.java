package com.example.owen.stud.viewPaint.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by loopeer on 2017/8/4.
 */

public class testPaint extends View {
    Paint mPaint = new Paint();
    Path mPath = new Path();

    public testPaint(Context context) {
        this(context, null);
    }

    public testPaint(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public testPaint(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(16);
        mPaint.setAntiAlias(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPath.addArc(200, 200, 400, 400, -225, 225);
            mPath.arcTo(400, 200, 600, 400, -180, 225, false);
            mPath.lineTo(400, 542);
            mPath.lineTo(200, 400);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(700, 100, 1000, 500, 100, 100, mPaint);
        canvas.drawPath(mPath, mPaint);
    }
}
