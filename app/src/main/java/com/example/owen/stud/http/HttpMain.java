package com.example.owen.stud.http;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.owen.stud.R;
import com.example.owen.stud.http.netParse.jsonParse.JsonActivity;
import com.example.owen.stud.http.netParse.xmlParse.XmlActivity;
import com.example.owen.stud.http.network.SimpleWebView;
import com.example.owen.stud.http.network.httpClient.HttpClient;
import com.example.owen.stud.http.network.httpURLConnection.HttpURLConnectionMain;
import com.example.owen.stud.http.network.okHttp.OkHttpMain;


public class HttpMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_main);
        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        Button btn4 = (Button) findViewById(R.id.button4);
        Button btn5 = (Button) findViewById(R.id.button5);
        Button btn6 = (Button) findViewById(R.id.button6);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HttpMain.this,HttpURLConnectionMain.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HttpMain.this, HttpClient.class));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HttpMain.this, SimpleWebView.class));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HttpMain.this, OkHttpMain.class));
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HttpMain.this, XmlActivity.class));
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HttpMain.this, JsonActivity.class));
            }
        });
    }
}
