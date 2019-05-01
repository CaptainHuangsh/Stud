package com.example.owen.stud.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by owen on 2017/5/1.
 */

public class MyIntentService extends IntentService {

    public MyIntentService() {
        this("myIntentService");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        super(name);//调用父类的有参构造函数
        //参数为工作线程名
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //复写onHandleIntent方法
        //实现耗时任务操作
        //打印当前的线程id
        String taskName = intent.getExtras().getString("taskName");
        Log.d("MyIntentService", "   Thread Id is : " + Thread.currentThread()
                .getId());
        switch (taskName) {
            case "task1":
                Log.i("myIntentService", "do task1");
                break;
            case "task2":
                Log.i("myIntentService", "do task2");
                break;
            default:
                break;
        }
    }

    @Override
    public void onCreate() {
        Log.i("myIntentService", "onCreate");
        super.onCreate();
    }

    /*复写onStartCommand()方法*/
    //默认实现将请求的Intent添加到工作队列里
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("myIntentService", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyIntentService", "onDestroy executed");
    }
}
