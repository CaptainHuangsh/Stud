package com.owen.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
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
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private MyService.DownloadBinder downloadBinder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

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
        btn3 = (Button) findViewById(R.id.start_service);
        btn4 = (Button) findViewById(R.id.stop_service);
        btn5 = (Button) findViewById(R.id.bind_service);
        btn6 = (Button) findViewById(R.id.unbind_service);
        txt = (TextView) findViewById(R.id.text1);
        btn2.setOnClickListener(this);
        btn.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
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
            case R.id.start_service:
                startService(new Intent(this, MyService.class));
                break;
            case R.id.stop_service:
                stopService(new Intent(this, MyService.class));
                break;
            case R.id.bind_service:
                Intent bindIntent = new Intent(this,MyService.class);
                bindService(bindIntent,connection,BIND_AUTO_CREATE);//绑定服务
                break;
            case R.id.unbind_service:
                unbindService(connection);//接触绑定
                break;
            default:
                break;
        }
    }
}
