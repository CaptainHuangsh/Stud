package com.owen.http.network.httpURLConnection;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.owen.http.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by owen on 2017/5/5.
 * 照搬《第一行代码-HttpUrlConnection》在19上可以运行成功，但是在6.0
 * 或更高的版本就不显示
 */

public class HttpURLConnectionMain extends Activity {
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httpurlconnection);
        Button btn = (Button) findViewById(R.id.send_request);
        text = (TextView) findViewById(R.id.respond_text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestWithHttpUrlConnection();
            }
        });
    }

    private void sendRequestWithHttpUrlConnection() {
        //开启线程来发起网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    Log.d("huangshaohua", "run");
                    URL url = new URL("http://www.baidu.com");
                    Log.d("huangshaohua", "" + url.toString());
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.connect();
                    Log.d("huangshaohua", "in");
                    InputStream in = connection.getInputStream();
                    //下面对获取到的数据流进行读取
                    reader = new BufferedReader(new
                            InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                        Log.d("huangshaohualine", "" + line);
                    }
                    Log.d("huangshaohua", "append" + response.toString());
                    showResponse(response.toString());
                    /*Message message = new Message();
                    message.what = SHOW_RESPONSE;
                    //服务器返回结果保存在Message中
                    message.obj = response.toString();
                    Log.d("huangshaohua",""+response.toString());
                    handler.sendMessage(message);*/
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    private void showResponse(final String s) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d("huangshaohua", "" + s);
                text.setText(s);
            }
        });

    }
}
