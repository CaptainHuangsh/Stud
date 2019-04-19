package com.example.owen.stud.utils;

import android.view.View;
import android.widget.Toast;

import com.example.owen.stud.fresco.MyApplication;

/**
 * Description:   TODO (用一句话描述该文件做什么)
 * author:        huangshaohua
 * Date:          2019/4/16
 * Description:
 */
public class ToastUtils {
    private static Toast mToast;
    private static long time;
    private static String oldMsg;

    public static void showMessage(String message) {
        if (mToast == null) {
            mToast = Toast.makeText(MyApplication.context, message, Toast.LENGTH_LONG);
        }
        mToast.setText(message);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
    }

    public static void showMessage(View view) {
        Toast toast = new Toast(MyApplication.context);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }

    public static void showMessage() {
        if (mToast == null) {
            mToast = new Toast(MyApplication.context);
        }
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
    }

}
