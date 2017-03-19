package com.owen.service;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 异步消息处理机制
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int UPDATE_TEXT = 1;
    private Button btn;
    private Button btn2;
    private TextView txt;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    Log.i("button1", "is tochange");
                    //在这里可以进行ui操作
                    txt.setText("Lord Huang is Handsome");
                    Log.i("button1", "is tochanged");
                    break;
                default:
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        txt = (TextView) findViewById(R.id.text1);
        btn2.setOnClickListener(this);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Log.i("button1", "is clicked");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handler.sendMessage(message);//将message对象发送出去
                    }
                }).start();
                break;
            case R.id.button2:
                Log.i("button2", "is clicked");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("button2", "is tochange");
                        txt.setText("Lord Huang is Handsome");
                        Log.i("button2", "is tochanged");
                    }
                }).start();//不要忘了.start();
                break;
            default:
                break;
        }
    }
}
