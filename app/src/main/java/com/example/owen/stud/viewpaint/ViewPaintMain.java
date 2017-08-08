package com.example.owen.stud.viewPaint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.owen.stud.R;

/**
 * Created by loopeer on 2017/7/25.
 */

public class ViewPaintMain extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_paint_main);
        setContentView(R.layout.activity_test);
        /*findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(ViewPaintMain.this, com.example.owen.stud.viewPaint.ViewPaintTime.class));
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(ViewPaintMain.this, com.example.owen.stud.viewpaint.ViewPaintDirect.class));
            }
        });*/
    }
}
