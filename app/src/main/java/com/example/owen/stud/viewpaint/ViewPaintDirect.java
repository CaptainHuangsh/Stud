package com.example.owen.stud.viewPaint;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.owen.stud.R;

/**
 * Created by loopeer on 2017/7/26.
 */

public class ViewPaintDirect extends Activity {
    com.example.owen.stud.viewpaint.MyCircle2 circle2;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_paint_left_right);
        circle2 = (com.example.owen.stud.viewpaint.MyCircle2)findViewById(R.id.mycirrle2);
        findViewById(R.id.left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circle2.eyesDirect(1);
//                Log.d("ViewPaintDirectLeftOnClick"," : 1");
            }
        });
        findViewById(R.id.middle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circle2.eyesDirect(0);
            }
        });
        findViewById(R.id.right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circle2.eyesDirect(2);
            }
        });
    }
}
