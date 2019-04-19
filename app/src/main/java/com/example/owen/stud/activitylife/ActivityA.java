package com.example.owen.stud.activitylife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.example.owen.stud.R;

/**
 * Description:   TODO (用一句话描述该文件做什么)
 * author:        huangshaohua
 * Date:          2019/4/19
 * Description:
 */
public class ActivityA extends Activity {
    private static final String ACTIVITY_NAME = "ActivityA";
    private static final String LOG_TAG = "test_activity_stack";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn);
        refreshTask();
        findViewById(R.id.btn_task).setOnClickListener(v -> startActivity(new Intent(this, ActivityB.class)));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        refreshTask();
    }

    private void refreshTask() {
        int taskId = getTaskId();
        Log.i(LOG_TAG, ACTIVITY_NAME + "所在的任务的id为: " + taskId);
        ((TextView) findViewById(R.id.tv_task)).setText(LOG_TAG + "  " + ACTIVITY_NAME + "所在的任务的id为: " + taskId);
    }
}
