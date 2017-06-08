package com.example.owen.stud.viewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.owen.stud.R;

/**
 * Created by owen on 2017/6/8.
 */

public class Fragment0 extends Fragment {

    private View mView;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_viewpager_fragment0, container, false);
            findViews();
        }
        return mView;
    }

    private void findViews() {
        textView = (TextView) mView.findViewById(R.id.text0);
    }
}
