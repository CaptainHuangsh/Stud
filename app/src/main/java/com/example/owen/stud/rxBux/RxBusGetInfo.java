package com.example.owen.stud.rxBux;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.owen.stud.R;
import com.laputapp.rx.RxBus;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by loopeer on 2017/7/27.
 */

@SuppressLint("Registered")
public class RxBusGetInfo extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_bus_get);
        init();
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        TextView textView = (TextView) findViewById(R.id.rx_bus_get_info);
        RxBus.getDefault().toFlowable(User.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    textView.setText(user.getUsername()+user.getPassword());
                });
    }
}
