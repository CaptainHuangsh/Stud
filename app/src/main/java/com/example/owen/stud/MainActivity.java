package com.example.owen.stud;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.owen.stud.activitylife.ActivityMain;
import com.example.owen.stud.animation.AnimationMain;
import com.example.owen.stud.baiduMap.BaiduMapMain;
import com.example.owen.stud.broadcast.BroadcastMain;
import com.example.owen.stud.contentProvider.ContentMain;
import com.example.owen.stud.dialog.DialogMain;
import com.example.owen.stud.fragment.FragmentMain;
import com.example.owen.stud.fresco.FrescoMain;
import com.example.owen.stud.http.HttpMain;
import com.example.owen.stud.listView.ListViewMain;
import com.example.owen.stud.notification.NotificationMain;
import com.example.owen.stud.recycleView.RecycleViewMain;
import com.example.owen.stud.rxBux.RxBusMain;
import com.example.owen.stud.rxjava2x.RxJava2XMain;
import com.example.owen.stud.service.ServiceMain;
import com.example.owen.stud.settings.SettingMain;
import com.example.owen.stud.viewPager.ViewPagerActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private String[] items = {
            "NetWork", "ActivityLife", "Fragment", "Broadcast", "Notification"
            , "Service", "Settings", "DialogMain", "RecycleView", "ListViewMain"
            , "BaiduMapMain", "ContentMain", "ViewPager", "Fresco"
            , "RxJava2x", "RxBus", "Test","Animation"
    };
    HashMap<String, Class<?>> hs = new HashMap<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this
                , android.R.layout.simple_list_item_1, items);
        ListView listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                launch(hs.get(items[position]));
            }
        });
    }


    public void init() {
        hs.put("NetWork", HttpMain.class);
        hs.put("ActivityLife", ActivityMain.class);
        hs.put("Fragment", FragmentMain.class);
        hs.put("Broadcast", BroadcastMain.class);
        hs.put("Notification", NotificationMain.class);
        hs.put("Service", ServiceMain.class);
        hs.put("Settings", SettingMain.class);
        hs.put("DialogMain", DialogMain.class);
        hs.put("RecycleView", RecycleViewMain.class);
        hs.put("ListViewMain", ListViewMain.class);
        hs.put("BaiduMapMain", BaiduMapMain.class);
        hs.put("ContentMain", ContentMain.class);
        hs.put("ViewPager", ViewPagerActivity.class);
        hs.put("Fresco", FrescoMain.class);
        hs.put("RxJava2x", RxJava2XMain.class);
        hs.put("RxBus", RxBusMain.class);
        hs.put("Test", TestActivity.class);
        hs.put("Animation", AnimationMain.class);
    }

    public void launch(Class<?> cls) {
        startActivity(new Intent(MainActivity.this, cls));
    }
}
