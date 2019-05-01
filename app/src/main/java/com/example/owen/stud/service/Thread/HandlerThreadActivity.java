package com.example.owen.stud.service.Thread;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.owen.stud.R;

/**
 * Description:   TODO (用一句话描述该文件做什么)
 * author:        huangshaohua
 * Date:          2019/4/24
 * Description:
 */
public class HandlerThreadActivity extends Activity {
    private static final int MSG_UPDATE_INFO = 0x100;
    private Handler mMainHandler = new Handler();
    private TextView textView;
    private Button button;
    private Handler threadHandler;
    private HandlerThread handlerThread;
    private boolean isUpdate = false;
    Message message = new Message();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn);
        textView = (TextView) findViewById(R.id.tv_task);
        button = (Button) findViewById(R.id.btn_task);
        initHandlerThread();
    }

    private void initHandlerThread() {
        handlerThread = new HandlerThread("stud");
        handlerThread.start();
        threadHandler = new Handler(handlerThread.getLooper(), new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                checkForUpdate();
                if (isUpdate) {
                    threadHandler.sendEmptyMessage(MSG_UPDATE_INFO);
                }
                return true;
            }
        }) {
            @Override
            public void handleMessage(Message msg) {
                Log.d("handlerThreadActivity", handlerThread.getName() + "");
            }
        };

        button.setOnClickListener(v -> {
            if (!isUpdate) {
//                threadHandler.sendEmptyMessage(MSG_UPDATE_INFO);

                threadHandler.sendEmptyMessage(MSG_UPDATE_INFO);
            } else {
                threadHandler.removeMessages(MSG_UPDATE_INFO);
            }
            isUpdate = !isUpdate;
        });

        message.what = MSG_UPDATE_INFO;
    }

    //模拟服务器解析数据
    private void checkForUpdate() {
        try {
            Thread.sleep(200);
            mMainHandler.post(new Runnable() {
                @Override
                public void run() {
                    String result = "实时更新中，当前股票行情：<font color='red'>%d</font>";
                    result = String.format(result, (int) (Math.random() * 5000 + 1000));
                    textView.setText(Html.fromHtml(result));
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handlerThread.quit();
        mMainHandler.removeCallbacksAndMessages(null);
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, HandlerThreadActivity.class);
        context.startActivity(intent);
    }
}
