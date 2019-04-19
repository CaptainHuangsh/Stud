package com.example.owen.stud.settings;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.owen.stud.R;

public class SettingMain extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_main);
        Button btn = (Button) findViewById(R.id.setting);
        Button btn2 = (Button) findViewById(R.id.setting2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingMain.this, Setting.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingMain.this, Setting2.class));
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("SettingsaInfo", "start");
        //Log中的空格不能识别
        //set the default value we define in the XML
        PreferenceManager.setDefaultValues(this, R.xml.pref_setting2, false);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        //get the value of the settings options

        boolean silentMode = preferences.getBoolean("silent_mode", false);
        Log.d("Settingsa Info",""+silentMode);
        boolean awesomeMode = preferences.getBoolean("awesome_mode", false);
        Log.d("Settingsa Info",""+awesomeMode);
        String string = preferences.getString("custom_storage", "");
        Log.d("Settingsa Info", "" + silentMode + "\n" + awesomeMode + "\n" + string);

    }
}
