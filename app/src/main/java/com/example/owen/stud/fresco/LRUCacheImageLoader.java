package com.example.owen.stud.fresco;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.LruCache;
import android.widget.ImageView;

import com.example.owen.stud.R;

/**
 * Created by owen on 2019/4/21.
 */

public class LRUCacheImageLoader {

    private LruCache<String, Bitmap> mMemoryCache;

    public LRUCacheImageLoader() {
        initCache();
    }

    private void initCache() {
        // 获取到可用内存的最大值，使用内存超出这个值会引起OutOfMemory异常。
        // LruCache通过构造函数传入缓存值，以KB为单位。
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        // 使用最大可用内存值的1/8作为缓存的大小。
        int cacheSize = maxMemory / 8;
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                // 重写此方法来衡量每张图片的大小，默认返回图片数量。
                return value.getByteCount() / 1024;
            }
        };
    }

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            mMemoryCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String key) {
        return mMemoryCache.get(key);
    }

    public void removeBitmapFromMemory(String key) {
        mMemoryCache.remove(key);
    }

    public void loadBitmap(int resId, ImageView imageView) {
        final String imageKey = String.valueOf(resId);
        final Bitmap bitmap = getBitmapFromMemCache(imageKey);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageResource(R.drawable.ic_menu_manage);
//            BitmapW
        }
    }

    class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(Integer... integers) {
//            final Bitmap bitmap = BitmapFactory.
            return null;
        }
    }
}
