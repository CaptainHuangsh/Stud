package com.example.owen.stud.recycleView;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.owen.stud.R;

import java.util.ArrayList;

/**
 * Created by owen on 2017/5/11.
 */

public class RecycleViewMain extends Activity {
    private ArrayList<MainAdapter.NextActivity> mNextActivities =
            new ArrayList<MainAdapter.NextActivity>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_main);
        initData();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycle_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MainAdapter adapter = new MainAdapter(mNextActivities);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        MainAdapter.NextActivity nextActivity = new MainAdapter.NextActivity("hehehe",RecycleViewMain.class);
        mNextActivities.add(nextActivity);
        mNextActivities.add(new MainAdapter.NextActivity("heheda",RecycleViewMain.class));
        mNextActivities.add(new MainAdapter.NextActivity("hehedada",RecycleViewMain.class));
        mNextActivities.add(new MainAdapter.NextActivity("heheheda",RecycleViewMain.class));

    }
}
