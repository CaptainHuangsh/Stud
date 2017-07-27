package com.example.owen.stud.fresco;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by loopeer on 2017/7/25.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
