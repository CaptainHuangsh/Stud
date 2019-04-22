package com.example.owen.stud.fresco;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.example.owen.stud.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by loopeer on 2017/7/25.
 */

public class FrescoMain extends Activity {

    private LRUCacheImageLoader imageLoader;
    private ImageView imageView;
    private String bitmapUrl = "https://avatars1.githubusercontent.com/u/18307109?v=4&s=460";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_main);
        initFresco();
        initLru();
    }

    private void initLru() {
        imageLoader = new LRUCacheImageLoader();
        imageView = (ImageView) findViewById(R.id.iv_im_loader);
    }

    public void showBitmap(View view) {
        Bitmap bitmap = imageLoader.getBitmapFromMemCache("bitmap");
        if (bitmap == null) {
            new BitmapThread(bitmapUrl).start();
        } else {
            imageView.setImageBitmap(bitmap);
        }
    }

    private void initFresco() {
        Uri uri = Uri.parse(bitmapUrl);
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        draweeView.setImageURI(uri);
    }

    private class BitmapThread extends Thread {
        private String bitmapUrl;

        BitmapThread(String bitmapUrl) {
            this.bitmapUrl = bitmapUrl;
        }

        @Override
        public void run() {
            super.run();
        }
    }

}
