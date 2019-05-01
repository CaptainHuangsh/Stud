package com.example.owen.stud.Animation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.owen.stud.R;

/**
 * Created by owen on 2019/4/27.
 */

public class TweenAnimTest extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim);
        initAnim();
        initAnimCode();
    }

    private void initAnimCode() {
//        RotateAnimation animation = new RotateAnimation(0f,180f,Animation.RELATIVE_TO_SELF)
    }


    private void initAnim() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_frame_anim);
        imageView.setImageResource(R.drawable.gakki_1);
        imageView.setBackground(null);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        imageView.startAnimation(animation);
    }
}
