package com.example.owen.stud.animation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by loopeer on 2017/9/4.
 */

public class MyView extends android.support.v7.widget.AppCompatImageView {

    private Matrix mMatrix;
    private static final float ZOOM_SCALE = 0.2f;
    private static final float REDUCE_SCALE = 0.0f;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, null, 0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mMatrix = new Matrix();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.concat(mMatrix);
        super.onDraw(canvas);
    }

    public void setScale(float scale) {
//        mMatrix.setScale(1 + scale, 1+scale, getMeasuredWidth() / 2, getMeasuredWidth() / 2);
        mMatrix.setScale(1 + scale, 1 + scale, getMeasuredWidth() / 2, getMeasuredWidth() / 2);
        invalidate();
    }

    public static float getZoomScale() {
        return ZOOM_SCALE;
    }

    public static float getReduceScale() {
        return REDUCE_SCALE;
    }


}
