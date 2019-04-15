package com.example.owen.stud.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.example.owen.stud.R;

public class NotificationMain extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_main);


        Button btn1 = (Button) findViewById(R.id.notification);
        Button btn2 = (Button) findViewById(R.id.expand_notification);
        Button btn3 = (Button) findViewById(R.id.headup_notification);

        btn1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
                //构造PendingIntent
                PendingIntent pendingIntent = PendingIntent.getActivity(NotificationMain.this, 0, intent, 0);
                Notification.Builder builder = new Notification.Builder(NotificationMain.this);
                builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                                R.mipmap.ic_launcher_round))
                        .setContentTitle("Basic Notification")
                        .setContentText("basic notification text")
                        .setSubText("basic subText");
                //通过NotificationManager来发出Notification
                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(
                                NOTIFICATION_SERVICE);
                notificationManager.notify(1, builder.build());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.sina.com"));
                PendingIntent pendingIntent =
                        PendingIntent.getActivity(NotificationMain.this, 0, intent, 0);
                Notification.Builder builder = new Notification.Builder(NotificationMain.this);
                builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                                R.mipmap.ic_launcher_round));
                //通过remoteViews来创建自定义的Notification视图
                RemoteViews contentView =
                        new RemoteViews(getPackageName(), R.layout.notification);
                contentView.setTextViewText(R.id.text_view, "show me when collapsed");
                RemoteViews expandedView =
                        new RemoteViews(getPackageName(), R.layout.notification2);
                expandedView.setTextViewText(R.id.text_view, "show me when expanded");
                Notification notification = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    notification = builder.build();
                }
                //指定视图
                notification.contentView = contentView;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    notification.bigContentView = expandedView;
                }
                //通过NotificationManager来发出Notification
                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(
                                NOTIFICATION_SERVICE);
                notificationManager.notify(0, notification);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Notification.Builder builder =
                        new Notification.Builder(NotificationMain.this)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setPriority(Notification.PRIORITY_DEFAULT)
                                .setCategory(Notification.CATEGORY_MESSAGE)//在5.0之前会崩溃
                                .setContentTitle("Headsup Notification")
                                .setContentText("I am a Headsup notification.");

                Intent push = new Intent();
                push.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                push.setClass(NotificationMain.this,NotificationMain.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(
                        NotificationMain.this,0,push,PendingIntent.FLAG_CANCEL_CURRENT);
                builder.setContentText("Heads-Up Notification")
                        .setFullScreenIntent(pendingIntent,true);

                NotificationManager nm = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);
                nm.notify(1,builder.build());
            }
        });
    }
}
