package com.example.owen.stud.service.musicService;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by owen on 2019/4/20.
 */

public class RemoteMusicService extends Service {
    //实现一个播放音乐的service
    public static final String TAG = "MusicService";
    public static final int MSG_SAY_HELLO = 101;
    public static final int MSG_MUSIC_PLAY = 102;
    public static final int MSG_MUSIC_STOP = 103;
    public MediaPlayer mediaPlayer;
    public boolean runing = false;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.i(TAG, "msg.what=" + msg.what);
            Log.i(TAG, "mHandler Thread =" + Thread.currentThread());
            switch (msg.what) {
                case MSG_SAY_HELLO:
                    Toast.makeText(getApplicationContext(), "hello,remote service", Toast.LENGTH_SHORT).show();
                    //通过message对象获取客户端传递过来的Messenger对象。
                    Messenger messenger = msg.replyTo;
                    if (messenger != null) {
                        Message messg = Message.obtain(null, MSG_SAY_HELLO);
                        try {
                            //向客户端发送消息
                            messenger.send(messg);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case MSG_MUSIC_PLAY:
                    //播放音乐
                    playOrPause();
                    break;
                case MSG_MUSIC_STOP:
                    //停止播放
                    stop();
                    break;
                default:
                    break;
            }
        }
    };
    //创建Mesenger 对象
    public Messenger mMessenger;
    private MusicBinder mBinder = new MusicBinder(this);

    public RemoteMusicService() {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("/storage/emulated/0/netease/cloudmusic/Music/雷军 - Are You OK.MP3");
            mediaPlayer.prepare();
            mediaPlayer.setLooping(true);
        } catch (Exception e) {

        }
        mMessenger = new Messenger(mHandler);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "in onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "in onStartCommand");
        Log.i(TAG, "MyService:" + this);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "in onDestroy");
        super.onDestroy();
    }

    public void playOrPause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        } else {
            mediaPlayer.start();
        }
    }

    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(Environment.getExternalStorageState() + "/storage/emulated/0/netease/cloudmusic/Music/雷军 - Are You OK.MP3");
                mediaPlayer.prepare();
                mediaPlayer.seekTo(0);
            } catch (Exception e) {
            }
        }
    }

    public class MusicBinder extends Binder {
        RemoteMusicService musicService;

        public MusicBinder(RemoteMusicService service) {
            this.musicService = service;
        }

        public RemoteMusicService getService() {
            return musicService;
        }

        public void playOrPause() {
            musicService.playOrPause();
        }

        public void stop() {
            musicService.stop();
        }

    }
}
