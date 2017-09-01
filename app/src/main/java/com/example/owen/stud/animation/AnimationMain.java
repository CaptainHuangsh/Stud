package com.example.owen.stud.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.owen.stud.R;

/**
 * Created by loopeer on 2017/8/31.
 */

public class AnimationMain extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_main);
        findViewById(R.id.btn_view_ani).setOnClickListener(v -> {
            startActivity(new Intent(this, ViewAnimation.class));
        });
        findViewById(R.id.btn_view_pro).setOnClickListener(v->{
            startActivity(new Intent(this, PropertyAnimation.class));
        });
    }
}
