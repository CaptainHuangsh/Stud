package com.example.owen.stud.Animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.owen.stud.R;

import java.util.HashMap;

/**
 * Created by owen on 2019/4/27.
 */

public class AnimMain extends Activity {
    private ListView listView;
    String[] mItems = {
            "FrameAnim", "TweenAnim","ValueAnimTest"
    };
    HashMap<String, Class<?>> hs = new HashMap<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_click);
        initLocalData();
        initView();
    }

    private void initLocalData() {
        hs.put(mItems[0], FrameAnimTest.class);
        hs.put(mItems[1], TweenAnimTest.class);
        hs.put(mItems[2], ValueAnimTest.class);
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.lv_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(AnimMain.this
                , android.R.layout.simple_list_item_1, mItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            launch(hs.get(mItems[position]));
        });

    }

    private void launch(Class<?> cls) {
        startActivity(new Intent(AnimMain.this, cls));
    }
}
