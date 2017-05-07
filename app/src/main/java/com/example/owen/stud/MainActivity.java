package com.example.owen.stud;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.owen.stud.activitylife.ActivityMain;
import com.example.owen.stud.broadcast.BroadcastMain;
import com.example.owen.stud.fragment.Fragment2;
import com.example.owen.stud.fragment.FragmentMain;
import com.example.owen.stud.http.HttpMain;
import com.example.owen.stud.notification.NotificationMain;
import com.example.owen.stud.service.ServiceMain;

public class MainActivity extends AppCompatActivity {
    private String[] items = {
            "NetWork", "ActivityLife", "Fragment", "Broadcast", "Notification"
            , "Service", "Settings"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this
        ,android.R.layout.simple_list_item_1,items);
        ListView listView = (ListView)findViewById(R.id.list_item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                launch(ServiceMain.class);
            }
        });
    }

    public void launch(Class<?> cls){
        startActivity(new Intent(MainActivity.this,cls));
    }
}
