package com.example.owen.stud.Animation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.owen.stud.R;

/**
 * Created by owen on 2019/4/27.
 */

public class ValueAnimTest extends Activity {

    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim);
        imageView = (ImageView) findViewById(R.id.iv_frame_anim);
        imageView.setImageResource(R.drawable.gakki_1);
        imageView.setBackground(null);
        imageView.setOnClickListener(new View.OnClickListener() {
            boolean r = true;

            @Override
            public void onClick(View v) {
                /*if (r) {
                    ValueAnimTest.this.RotateAnimation(imageView);
                } else {
                    ValueAnimTest.this.AlpahAnimation(imageView);
                }
                r = !r;*/
//                startValueAnimation();
//                startAnimSet(imageView);
                useCustomEvaluator(imageView);
            }
        });
    }

    private void RotateAnimation(View view) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);
        anim.setDuration(1000);
        anim.start();
    }

    private void AlpahAnimation(View view) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.8f, 0.6f, 0.4f, 0.2f, 0.0f);
        anim.setRepeatCount(-1);
        anim.setRepeatMode(ObjectAnimator.REVERSE);
        anim.setDuration(2000);
        anim.start();
    }

    ValueAnimator.AnimatorUpdateListener listener = new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            float newValue = (Float) animation.getAnimatedValue();
            Log.d("ValueAnimTest", "新的属性值:" + newValue);
            //将数字设置到具体对象
            imageView.setAlpha(newValue);
        }
    };

    private void startValueAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.setDuration(1000);
        animator.addUpdateListener(listener);
        animator.start();
    }

    private void startAnimFromXml() {
        ValueAnimator animator = (ValueAnimator) AnimatorInflater.loadAnimator(
                this, R.animator.value_anim);
    }

    private void startAnimSet(View view) {
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);
        anim1.setDuration(1000);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        anim2.setDuration(1000);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.0f, 1.0f);
        anim3.setDuration(1000);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.0f, 1.0f);
        anim4.setDuration(1000);
        ObjectAnimator anim5 = ObjectAnimator.ofFloat(view, "translationX", 0f, 1.0f);
        anim5.setDuration(1000);
        AnimatorSet animatorSet = new AnimatorSet();
        /*animatorSet.play(anim1).with(anim2).after(anim3).before(anim4);*/
        animatorSet.playTogether(anim1, anim2, anim3, anim4, anim5);
        animatorSet.start();
    }

    private void useCustomEvaluator(View view) {
        ObjectAnimator animator = ObjectAnimator.ofObject(view, "y", new CustomEvaluator(), 0f, 200f);
        animator.setDuration(2000);
        animator.start();
    }

    public class CustomEvaluator implements TypeEvaluator<Float> {
        @Override
        public Float evaluate(float fraction, Float startValue, Float endValue) {
            Float newValue = startValue + fraction * (endValue - startValue);
            Log.d("ValueAnimTest", "fraction= " + fraction
                    + ",start= " + startValue + ",end= " + endValue + ", newValue= " + newValue);
            return newValue;
        }
    }

}
