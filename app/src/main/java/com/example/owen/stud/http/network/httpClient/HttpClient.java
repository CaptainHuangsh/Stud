package com.example.owen.stud.http.network.httpClient;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.owen.stud.R;


/**
 * Android6.0之后被弃用
 */
public class HttpClient extends AppCompatActivity {
    public static final int SHOW_RESPONSE = 0;
    private TextView text;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SHOW_RESPONSE:
                    String response = (String) msg.obj;
                    Log.d("huangshaohua", "handle" + response);
                    text.setText(response);
                    break;
                default:
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_client);
        Button btn = (Button) findViewById(R.id.send_request2);
        text = (TextView) findViewById(R.id.respond_text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestWithHttpUrlConnection();
            }
        });
    }

    private void sendRequestWithHttpUrlConnection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpClient httpClient = new HttpClient();

                } catch (Exception e) {
                }
            }
        }).start();
    }
}
