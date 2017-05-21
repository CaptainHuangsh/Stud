package com.example.owen.stud.contentProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.owen.stud.R;

/**
 * Created by owen on 2017/5/21.
 */

public class ContentMain extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider_main);
        ((Button)findViewById(R.id.to_contact)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContentMain.this,ContactActivity.class));
            }
        });
    }
}
