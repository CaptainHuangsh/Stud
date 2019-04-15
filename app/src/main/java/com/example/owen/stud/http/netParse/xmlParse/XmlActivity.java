package com.example.owen.stud.http.netParse.xmlParse;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.owen.stud.R;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.StringReader;
import javax.xml.parsers.SAXParserFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by owen on 2017/5/6.
 */

public class XmlActivity extends Activity {
    private static final String HOSTS = "http://192.168.0.110:8888/get_data.xml";
    private static final int TYPE_PULL = 0;
    private static final int TYPE_SAX = 1;
    TextView text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_xml_parse);
        Button btn = (Button) findViewById(R.id.send_request);
        Button btn2 = (Button) findViewById(R.id.json_gson);
        text = (TextView) findViewById(R.id.respond_text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestWithOkHttp(TYPE_PULL);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestWithOkHttp(TYPE_SAX);
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
                    if (type == TYPE_PULL)
                        parseWithPull(responseText);
                    else if (type == TYPE_SAX)
                        parseWithSax(responseText);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseWithSax(String xmlData) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader reader = factory.newSAXParser().getXMLReader();
            ContentHandler handler = new ContentHandler();
            //将ContentHandler的实例设置到XMLReader中来
            reader.setContentHandler(handler);
            //开始执行解析
            reader.parse(new InputSource(new StringReader(xmlData)));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                            Log.d("XmlActivity", "id : " + id);
                            Log.d("XmlActivity", "name : " + name);
                            Log.d("XmlActivity", "version : " + version);
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
