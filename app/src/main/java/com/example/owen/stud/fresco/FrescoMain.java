package com.example.owen.stud.fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.owen.stud.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by loopeer on 2017/7/25.
 */

public class FrescoMain extends Activity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_main);
        Uri uri = Uri.parse("https://avatars1.githubusercontent.com/u/18307109?v=4&s=460");
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        draweeView.setImageURI(uri);
    }
}
