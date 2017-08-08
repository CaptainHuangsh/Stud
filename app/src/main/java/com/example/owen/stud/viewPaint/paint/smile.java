package com.example.owen.stud.viewPaint.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by loopeer on 2017/8/4.
 */

public class smile extends View {
    Paint mPaint = new Paint();
    Path mPath = new Path();
    public smile(Context context) {
        this(context,null);
    }

    public smile(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public smile(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(15);
        mPaint.setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(300,300,200,mPaint);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawOval(150,150,250,250,mPaint);
        }
    }
}
