package com.owen.brpadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFiter;
    private NetworkchangeReciever networkchangeReciever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFiter = new IntentFilter();
        intentFiter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkchangeReciever = new NetworkchangeReciever();
        registerReceiver(networkchangeReciever,intentFiter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkchangeReciever);
    }

    private class NetworkchangeReciever extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo != null && networkInfo.isAvailable()){
                Toast.makeText(MainActivity.this,"network is available",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this,"network is unavailable",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
