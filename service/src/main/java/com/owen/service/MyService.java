package com.owen.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by owen on 2017/5/1.
 */

public class MyService extends Service {
    private DownloadBinder mBinder = new DownloadBinder();
    private Context mContext;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    /**
     * 服务创建时调用
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService", "onCreate");
        mContext = getApplication();
        Notification notification;
//        = new Notification(R.mipmap.ic_launcher, "notification comes",
//                System.currentTimeMillis());
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        notification = new Notification.Builder(mContext)
                .setContentTitle("huangshaohua")
                .setContentText("haoshuai")
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();

//        notification.setLatestEventInfo(this,"this is tittle","this is content",pendingIntent);
        //上面的方法已经被弃用了，现在时Builder方法
        startForeground(1, notification);

        /*Notification notification = new Notification.Builder(mContext)
                .setContentTitle("huangshaohua")
                .setContentText("haoshuai")
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();*/

    }

    /**
     * 每次启动时调用
     *
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 服务销毁时调用
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService", "onDestroy");
    }

    class DownloadBinder extends Binder {

        public void startDownload() {
            Log.d("MyService", "startDownload");
        }

        public int getProgress() {
            Log.d("MyService", "getProgress");
            return 0;
        }

    }
}
