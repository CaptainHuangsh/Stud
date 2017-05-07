package com.example.owen.stud.settings;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.owen.stud.R;

/**
 * 主页设置
 * Created by owen on 2017/5/3.
 * 以前的PreferenceActivity已经不提倡使用，官方推荐使用Fragment
 */

public class Setting extends AppCompatActivity {
    public static final String PRES_NAME = "com.owen.settings";
    public Context mContext = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting2);
        mContext = (Context) Setting.this;

    }

    public static class SettingsFragment extends PreferenceFragment
            implements SharedPreferences.OnSharedPreferenceChangeListener {
        private Preference mPreference;
        private SharedPreferences mSharedPreferences;
        private SharedPreferences.Editor mEditor;

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_setting1);
            mSharedPreferences = getActivity().getSharedPreferences(Setting.PRES_NAME,
                    MODE_PRIVATE);
            mSharedPreferences.registerOnSharedPreferenceChangeListener(this);
            mEditor = mSharedPreferences.edit();
            findPreference();
            loadPrefernece(mSharedPreferences);
        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        }

        private void findPreference(){
            mPreference = (PreferenceScreen) findPreference("setting_key1");
        }

        private void loadPrefernece(SharedPreferences set) {

        }
    }
}
