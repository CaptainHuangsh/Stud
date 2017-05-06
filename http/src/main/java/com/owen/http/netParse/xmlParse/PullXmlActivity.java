package com.owen.http.netParse.xmlParse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.owen.http.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by owen on 2017/5/6.
 */

public class PullXmlActivity extends AppCompatActivity {
    TextView text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        Button btn = (Button) findViewById(R.id.send_request);
        text = (TextView) findViewById(R.id.respond_text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestWithOkHttp();
            }
        });
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://192.168.0.110:8888/get_data.xml")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseText = response.body().string();
                    parseWithPull(responseText);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseWithPull(String xmlData) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));
            int eventType = xmlPullParser.getEventType();
            String id = "";
            String name = "";
            String version = "";
            while (eventType != xmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch (eventType) {
                    //开始解析某个节点
                    case XmlPullParser.START_TAG: {
                        if ("id".equals(nodeName)) {
                            id = xmlPullParser.nextText();
                        } else if ("name".equals(nodeName)) {
                            name = xmlPullParser.nextText();
                        } else if ("version".equals(nodeName)) {
                            version = xmlPullParser.nextText();
                        }
                        break;
                    }
                    case XmlPullParser.END_TAG:
                        if ("app".equals(nodeName)) {
                            Log.d("PullXmlActivity", "id : " + id);
                            Log.d("PullXmlActivity", "name : " + name);
                            Log.d("PullXmlActivity", "version : " + version);
                        }
                        break;
                    default:
                        break;
                }
                eventType = xmlPullParser.next();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
/*

所用到的文件
* <apps>
	<app>
		<id>1</id>
		<name>Google Maps</name>
		<version>1.0</version>
	</app>
	<app>
		<id>2</id>
		<name>Chrome</name>
		<version>2.1</version>
	</app>
	<app>
		<id>3</id>
		<name>Google Paly</name>
		<version>2.3</version>
	</app>
</apps>
* */
}
