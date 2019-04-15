package com.example.owen.stud.listView;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.owen.stud.R;

public class ListViewMain extends Activity {
    private ListView listView;
    private ListViewAdapter adapter;
    private String[] beans = new String[]{"1", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "11", "12", "13"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_main);

        initView();
    }

    private void initView() {
        Log.i("htp", "beans.size:" + beans.length);
        listView = (ListView) findViewById(R.id.listView1);
        adapter = new ListViewAdapter(ListViewMain.this, beans);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

}
