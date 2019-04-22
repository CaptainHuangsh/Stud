package com.example.owen.stud.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.owen.stud.R;
import com.example.owen.stud.service.musicService.MusicService;
import com.example.owen.stud.service.musicService.RemoteMusicService;

import static com.example.owen.stud.service.musicService.RemoteMusicService.MSG_MUSIC_PLAY;
import static com.example.owen.stud.service.musicService.RemoteMusicService.MSG_MUSIC_STOP;
import static com.example.owen.stud.service.musicService.RemoteMusicService.MSG_SAY_HELLO;

/**
 * Created by owen on 2019/4/20.
 */

public class MusicActivity extends Activity implements MusicService.OnTestListener {

    private MusicService.MusicBinder mBinder;
    private MusicService mService;
    private ServiceConnection sc = new MusicServiceConnection();
    private TextView textView;
    private Messenger mRemoteMessenger;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case MSG_SAY_HELLO:
                    textView.setText("hello");
                    break;
                default:
                    break;
            }
        }
    };
    private Messenger mMessenger = new Messenger(mHandler);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btns);
        init();
    }

    private void init() {
        textView = (TextView) findViewById(R.id.tv_music);
        findViewById(R.id.btn_1).setOnClickListener(v -> {
            //绑定Service
            Intent intent = new Intent(this, MusicService.class);
            startService(intent);
            bindService(intent, sc, Context.BIND_AUTO_CREATE);

        });

        findViewById(R.id.btn_2).setOnClickListener(v -> {
            //解除绑定
            unbindService(sc);
        });
        findViewById(R.id.btn_3).setOnClickListener(v -> {
            //也可以直接通过binder获取的service实例，操作播放暂停方法
//            mService.playOrPause();
            //通过binder实例操作binder内部的service方法
            mBinder.playOrPause();
        });
        findViewById(R.id.btn_4).setOnClickListener(v -> {
//            mService.stop();
            mBinder.stop();
        });
        findViewById(R.id.btn_5).setOnClickListener(v -> {
            Intent intent = new Intent(this, RemoteMusicService.class);    // 设置action 与service在清单文件中的action保持一致
            bindService(intent, new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    mRemoteMessenger = new Messenger(iBinder);
                    textView.setText("connected");
                }

                @Override
                public void onServiceDisconnected(ComponentName componentName) {
                    mRemoteMessenger = null;
                    textView.setText("disconnected");
                }
            }, Context.BIND_AUTO_CREATE);
            textView.setText("connecting");
        });
        findViewById(R.id.btn_6).setOnClickListener(v -> {
            sendMsg(MSG_SAY_HELLO);
        });
        findViewById(R.id.btn_7).setOnClickListener(v -> {
            sendMsg(MSG_MUSIC_PLAY);
        });
        findViewById(R.id.btn_8).setOnClickListener(v -> {
            sendMsg(MSG_MUSIC_STOP);
        });
    }

    private void sendMsg(int what) {
        if (mRemoteMessenger == null) return;    //创建消息，设置what属性
        Message msg = Message.obtain(null, what);    //replyTo不是必须的，如果希望Service向客户端发送消息则需要设置。
        msg.replyTo = mMessenger;
        try {        //发送消息
            mRemoteMessenger.send(msg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void unbind() {
     /*//解除与Service的连接
        unbindService(mConnection);
        mStateText.setText("disconnecting");
        mBindState = STATE_DISCONNECTED;
        mStateText.setText("disconnected");
        mBtnBind.setText("绑定");*/
    }

    @Override
    protected void onDestroy() {
//        unbindService(sc);
        super.onDestroy();
    }

    @Override
    public void onTest(String str) {
        //接口回调，提供给service向activity的通信，实现双向通信
        textView.setText(str);
    }

    class MusicServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mBinder = (MusicService.MusicBinder) iBinder;
            mService = mBinder.getService();
            mBinder.setOnTestListener(MusicActivity.this);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mService = null;
        }
    }
}
