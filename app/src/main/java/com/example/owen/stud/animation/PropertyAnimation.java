package com.example.owen.stud.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.example.owen.stud.R;

/**
 * Created by loopeer on 2017/9/1.
 */

public class PropertyAnimation extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_property);
        ImageView img = (ImageView) findViewById(R.id.img_pro);
        MyView mv = (MyView) findViewById(R.id.my_view);
        findViewById(R.id.pro_ani_obj).setOnClickListener(v -> translateAnimation(img));
        findViewById(R.id.pro_ani_rot).setOnClickListener(v -> rotateAnimation(img));
        findViewById(R.id.pro_btn3).setOnClickListener(v -> scaleMatrix(mv));
    }

    float[] tx, ty;
    boolean isXY = true;

    private void translateAnimation(View view) {

        tx = new float[]{-300, 300};
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
                view,
                isXY ? View.TRANSLATION_X : View.TRANSLATION_Y,
                tx
        );
        objectAnimator.setDuration(3000);
        objectAnimator.start();
        isXY = !isXY;
    }

    int is0XY = 0;

    private void rotateAnimation(View view) {
        tx = new float[]{-300, 300};
        Property<View, Float> property = null;
        switch (is0XY % 3) {
            case 0:
                property = View.ROTATION;
                break;
            case 1:
                property = View.ROTATION_X;
                break;
            case 2:
                property = View.ROTATION_Y;
                break;
        }
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
                view,
                property,
                tx
        );
        objectAnimator.setDuration(3000);
        objectAnimator.start();
        is0XY++;
    }

    boolean isIn = true;

    private void scaleMatrix(MyView view) {
        if (isIn) {
            getScaleAnimator(view, 0.0f, 0.2f).start();
        } else {
            getScaleAnimator(view, 0.2f, 0.0f).start();
        }
        isIn = !isIn;
    }

    private ValueAnimator getScaleAnimator(final MyView view, float from, float to) {
        ValueAnimator animator = ValueAnimator.ofFloat(from, to);
        animator.setDuration(3000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                AnimatorScaleType.INSTANCE.setScale((float) animation.getAnimatedValue());
//                ImageDisplayHelper.setImageScaleType(view, AnimatorScaleType.INSTANCE);

                view.setScale((float) 0.2);
            }
        });
        return animator;
    }
}
