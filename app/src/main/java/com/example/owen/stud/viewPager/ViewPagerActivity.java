package com.example.owen.stud.viewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.owen.stud.R;

/**
 * Created by owen on 2017/6/8.
 */

public class ViewPagerActivity extends AppCompatActivity {
    ViewPager mViewPager;
    HomePagerAdapter adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_main);
        findViews();
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.viewpager_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_page:
//                Toast.makeText(this, "hhh", Toast.LENGTH_SHORT).show();
                Fragment0 fm = new Fragment0();
                adapter.addTab(fm,"lll");
                adapter.notifyDataSetChanged();
//                mViewPager;
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {
        adapter = new HomePagerAdapter(getSupportFragmentManager());
        Fragment0 fm0 = new Fragment0();
        Fragment0 fm1 = new Fragment0();
        adapter.addTab(fm0, "aaa");
        adapter.addTab(fm1, "bbb");
        mViewPager.setAdapter(adapter);
//        mTabLayout.setupWithViewPager(mViewPager, false);

    }

    private void findViews() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
    }


}
