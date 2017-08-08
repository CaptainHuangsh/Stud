package com.example.owen.stud.viewPaint.paint;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by loopeer on 2017/8/3.
 */

public class clock extends View {
    private final int mWidth = 200;
    private final int mHeight = 200;

    public clock(Context context) {
        this(context,null);
    }

    public clock(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public clock(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        @SuppressLint("DrawAllocation") Paint paintCircle = new Paint();
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setAntiAlias(true);
        paintCircle.setStrokeWidth(5);
        canvas.drawCircle(mWidth/2,mHeight/2,mWidth/2,paintCircle);
    }
}
