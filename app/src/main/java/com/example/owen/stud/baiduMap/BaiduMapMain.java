package com.example.owen.stud.baiduMap;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.example.owen.stud.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by owen on 2017/5/13.
 */

public class BaiduMapMain extends Activity {
    public LocationClient mLocationClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidu_main);
        initLocation();
    }

    private void initLocation() {
        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(new MyLocationListener());
        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(BaiduMapMain.this, android.Manifest
                .permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(BaiduMapMain.this, android.Manifest
                .permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(android.Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(BaiduMapMain.this, android.Manifest
                .permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(BaiduMapMain.this, permissions, 1);
            //Android6.0之后动态申请权限
        } else {
            requestLocation();
        }

    }

    private void requestLocation() {
        refreshLocation();
        mLocationClient.start();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(BaiduMapMain.this, "必须获得以上权限才能正常使用", Toast.LENGTH_SHORT)
                                    .show();
                            finish();//不同意就退出
                            return;
                        }
                    }
                    requestLocation();
                } else {
                    Toast.makeText(BaiduMapMain.this, "发生未知错误", Toast.LENGTH_SHORT)
                            .show();
                    finish();
                }
                break;
            default:
                break;
        }
    }

    public void refreshLocation() {
        LocationClientOption option = new LocationClientOption();
//        option.setScanSpan(5000);
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
    }

    @Override
    protected void onDestroy() {
        mLocationClient.stop();
        super.onDestroy();
    }

    public class MyLocationListener implements BDLocationListener {
        //在23上可以成功，但是在19上就不行，但是问题暂未确定出在Android版本还是手机没有sim卡
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            StringBuilder currentPosition = new StringBuilder();
            currentPosition.append("纬度：").append(bdLocation.getLatitude())
                    .append("\n");
            currentPosition.append("经度：").append(bdLocation.getLongitude())
                    .append("\n");
            currentPosition.append("城市：").append(bdLocation.getCity())
                    .append("\n");
            Log.d("huangshaohua", "" + currentPosition.toString());
            Log.d("huangshaohua" , "errotype: "+ bdLocation.getLocType());
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }
}
