package com.example.owen.stud.Animation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;

import com.example.owen.stud.R;

/**
 * Created by owen on 2019/4/27.
 */

public class FrameAnimTest extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim);
        initAnim();
    }

    private void initAnim() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_frame_anim);
        ((AnimationDrawable) imageView.getBackground()).start();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void initCodeAnim() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_frame_anim);
        AnimationDrawable anim = new AnimationDrawable();
        for (int i = 1; i < 37; i++) {
            //获取图片资源ID
            int id = getResources().getIdentifier("gakki_" + i, "drawable", getPackageName());
            Drawable drawable = getResources().getDrawable(id);
            //将Drawable添加到帧动画中
            anim.addFrame(drawable, 80);
        }
        anim.setOneShot(false);
        imageView.setBackground(anim);
        anim.start();
    }
}
