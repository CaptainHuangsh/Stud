package com.example.owen.stud.rxBux;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.owen.stud.R;
import com.laputapp.rx.RxBus;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by loopeer on 2017/7/27.
 */

public class RxBusMain extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_bus_main);
        findViewById(R.id.rx_bus_sent).setOnClickListener(v->test());

        TextView textView = (TextView) findViewById(R.id.asda);
        RxBus.getDefault().toFlowable(User.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    textView.setText(user.getUsername() + user.getPassword());
                });
    }

    private void test() {
        User user = new User("huangshaohua", "hehe");
        RxBus.getDefault().send(user);
    }
}
