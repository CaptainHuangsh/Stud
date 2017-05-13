package com.example.owen.stud.http.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.owen.stud.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by owen on 2017/5/13.
 */

public class RetrofitActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://www.baidu.com")
                .build();
    }


}
