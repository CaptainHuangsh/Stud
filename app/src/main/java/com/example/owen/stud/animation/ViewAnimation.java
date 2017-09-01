package com.example.owen.stud.animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.owen.stud.R;

/**
 * Created by loopeer on 2017/8/31.
 */

public class ViewAnimation extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_view);
        ImageView img = (ImageView) findViewById(R.id.view_animation);
        findViewById(R.id.ani_tra).setOnClickListener(v-> alphaAnimation(img));
        findViewById(R.id.ani_ratate).setOnClickListener(v->rotateAnimation(img));
        findViewById(R.id.ani_translate).setOnClickListener(v->translateAnimation(img));
        findViewById(R.id.ani_scale).setOnClickListener(v->scaleAnimation(img));
        findViewById(R.id.ani_set).setOnClickListener(v->doAnimationSet(img));
    }

    private void alphaAnimation(View view){
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(2000);
        view.startAnimation(alphaAnimation);
    }

    private void rotateAnimation(View view){
        RotateAnimation rotateAnimation = new RotateAnimation(0,360,100,100);
        rotateAnimation.setDuration(2000);
        view.startAnimation(rotateAnimation);
    }

    private void translateAnimation(View view){
        TranslateAnimation translateAnimation = new TranslateAnimation(0,200,0,300);
        translateAnimation.setDuration(2000);
        view.startAnimation(translateAnimation);
    }

    private void scaleAnimation(View view){
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,2,0,2);
        scaleAnimation.setDuration(2000);
        view.startAnimation(scaleAnimation);
    }

    private void doAnimationSet(View view){
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(5000);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(2000);
        animationSet.addAnimation(alphaAnimation);
        RotateAnimation rotateAnimation = new RotateAnimation(0,360,100,100);
        rotateAnimation.setDuration(2000);
        animationSet.addAnimation(rotateAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(0,200,0,300);
        translateAnimation.setDuration(2000);
        animationSet.addAnimation(translateAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,2,0,2);
        scaleAnimation.setDuration(2000);
        animationSet.addAnimation(scaleAnimation);

        view.startAnimation(animationSet);

        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}
