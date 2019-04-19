package com.example.owen.stud.activitylife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.owen.stud.R;

public class ActivityMain extends Activity {
    private static final String TAG = "ActivityMain";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_life_main);
        Log.i(TAG, "onCreate");
        Toast.makeText(ActivityMain.this, TAG + "  onCreate", Toast.LENGTH_SHORT).show();
        Button btn = (Button) findViewById(R.id.start_second);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent().setClass(ActivityMain.this, SecondActivity.class));
            }
        });
        Button btn2 = (Button)findViewById(R.id.start_dialog);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityMain.this,DialogActivity.class));
            }
        });
        findViewById(R.id.btn_task).setOnClickListener(v-> startActivity(new Intent(this,ActivityA.class)));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
        Toast.makeText(ActivityMain.this, TAG + "  onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
        Toast.makeText(ActivityMain.this, TAG + "  onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
        Toast.makeText(ActivityMain.this, TAG + "  onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
        Toast.makeText(ActivityMain.this, TAG + "  onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
        Toast.makeText(ActivityMain.this, TAG + "  onRestart", Toast.LENGTH_SHORT).show();
    }
}
