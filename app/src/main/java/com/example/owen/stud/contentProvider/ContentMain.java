package com.example.owen.stud.contentProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.owen.stud.R;

/**
 * Created by owen on 2017/5/21.
 */

public class ContentMain extends Activity {
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
        ((Button)findViewById(R.id.to_provider)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContentMain.this,ProviderActivity.class));
            }
        });
        ((Button)findViewById(R.id.to_sms)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContentMain.this,SmsActivity.class));
            }
        });
        ((Button)findViewById(R.id.to_camera)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContentMain.this,CameraAlbumActivity.class));
            }
        });
    }
}
