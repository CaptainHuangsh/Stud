package com.example.owen.stud.http.netParse.jsonParse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.owen.stud.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by owen on 2017/5/7.
 */

public class JsonActivity extends AppCompatActivity {
    private static final String HOSTS = "http://192.168.0.110:8888/get_data.json";
    private static final int TYPE_JSONOBJECT = 0;
    private static final int TYPE_GSON = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_json_parse);
        Button btn = (Button) findViewById(R.id.send_request);
        Button btn2 = (Button) findViewById(R.id.json_gson);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestWithOkHttp(TYPE_JSONOBJECT);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestWithOkHttp(TYPE_GSON);
            }
        });
    }

    private void sendRequestWithOkHttp(final int type) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(HOSTS)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseText = response.body().string();
                    if (type == TYPE_JSONOBJECT)
                        parseJSONWithJSONObject(responseText);
                    else if (type == TYPE_GSON)
                        parseJSONWithGson(responseText);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseJSONWithGson(String jsonData) {
        Gson gson = new Gson();
        List<App> appList = gson.fromJson(jsonData,
                new TypeToken<List<App>>() {
                }.getType());
        for (App app : appList) {
            Log.d("JsonActivityGson", "id : " + app.getId());
            Log.d("JsonActivityGson", "name : " + app.getName());
            Log.d("JsonActivityGson","version : "+app.getVersion());
        }
    }

    private void parseJSONWithJSONObject(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");
                Log.d("JsonActivityJSONObject", "id : " + id);
                Log.d("JsonActivityJSONObject", "name : " + name);
                Log.d("JsonActivityJSONObject", "version : " + version);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
