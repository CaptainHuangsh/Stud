package com.example.owen.stud.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.owen.stud.R;

/**
 * Created by owen on 2017/5/10.
 */

public class DialogMain extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_main);
        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BaseDialog dialog = new BaseDialog(DialogMain.this);
                dialog.setTitle("提示");
                dialog.setMessage("确定退出应用？");
                dialog.setYesOnclickListener("确定", new BaseDialog.onYesOnclickListener() {
                    @Override
                    public void onYesClick() {
                        Toast.makeText(DialogMain.this, "点击了--确定--按钮", Toast.LENGTH_LONG).show();
                        finish();
                        dialog.dismiss();
                    }
                });
                dialog.setNoOnclickListener("取消", new BaseDialog.onNoOnclickListener() {
                    @Override
                    public void onNoClick() {
                        Toast.makeText(DialogMain.this, "点击了--取消--按钮", Toast.LENGTH_LONG).show();
                        finish();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}
