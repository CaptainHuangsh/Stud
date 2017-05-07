package com.example.owen.stud.settings;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.owen.stud.R;

/**
 * Created by owen on 2017/5/3.
 */

public class Setting2 extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_setting2);
    }
}
