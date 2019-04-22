package com.example.owen.stud.service.musicService;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by owen on 2019/4/20.
 */

public class MusicService extends Service {
    //实现一个播放音乐的service
    public static final String TAG = "MusicService";
    public MediaPlayer mediaPlayer;
    public boolean runing = false;
    private MusicBinder mBinder = new MusicBinder(this);

    public MusicService() {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("/storage/emulated/0/netease/cloudmusic/Music/雷军 - Are You OK.MP3");
            mediaPlayer.prepare();
            mediaPlayer.setLooping(true);
        } catch (Exception e) {

        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
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
        MusicService musicService;
        private OnTestListener mListener;

        public MusicBinder(MusicService service) {
            this.musicService = service;
        }

        public MusicService getService() {
            return musicService;
        }

        public void playOrPause() {
            musicService.playOrPause();
            mListener.onTest(musicService.mediaPlayer.isPlaying() ? "play" : "pause");
        }

        public void stop() {
            musicService.stop();
            mListener.onTest("stop");
        }

        // MyBinder 里面提供一个注册回调的方法
        public void setOnTestListener(OnTestListener listener) {
            this.mListener = listener;
        }

    }

    //自定义一个回调接口
    public interface OnTestListener {
        void onTest(String str);
    }
}
