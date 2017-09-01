package com.example.owen.stud.animation;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
        findViewById(R.id.pro_ani_obj).setOnClickListener(v -> objectAnimation(img));
    }

    float[] tx,ty;

    private void objectAnimation(View view) {
        tx = new float[]{-300,300};
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
                view,
                View.TRANSLATION_X,
                tx
        );
        objectAnimator.setDuration(3000);
        objectAnimator.start();

    }
}
