package com.owen.settings;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;

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
