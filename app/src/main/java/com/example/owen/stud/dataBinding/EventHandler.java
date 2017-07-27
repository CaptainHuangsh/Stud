package com.example.owen.stud.dataBinding;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by loopeer on 2017/7/25.
 */

public class EventHandler {
    private Context mContext;
    public EventHandler(Context context) {
        mContext = context;
    }

    public void onClickFriend(View view) {
        //onClick方法没有成功调用，问题未知
        Toast.makeText(mContext, "onClickFriend", Toast.LENGTH_LONG).show();
        Log.d("EventHandlerD","onClickFriend");
    }

    public void onTaskClick(Task task) {
        task.run();
    }

    public void onTaskClickWithParams(View view, Task task) {
        task.run();
    }

    public void onCompletedChanged(Task task, boolean completed) {
        //也没有成功，怀疑原因，java8语法的不支持
        if(completed) {
            task.run();
        }
    }
}