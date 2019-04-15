package com.example.owen.stud.contentProvider;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.owen.stud.R;

/**
 * Created by owen on 2017/5/21.
 */

public class ProviderActivity extends Activity {

    private String newId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        ((Button) findViewById(R.id.add_data)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //添加数据
                Uri uri = Uri.parse("content://com.example.owen.stud.provider/book");
                ContentValues values = new ContentValues();
                values.put("name", "A Clash of Kings");
                values.put("author", "George Martin");
                values.put("pages", 1040);
                values.put("price", 22.85);
                Uri newUri = getContentResolver().insert(uri, values);
                newId = newUri.getPathSegments().get(1);
            }
        });
        ((Button) findViewById(R.id.query_data)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //查询数据
                Uri uri = Uri.parse("content://com.example.owen.stud.provider/book");
                Cursor cursor = getContentResolver().query(uri, null, null,
                        null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("ProviderActivityQuery", "book name : " + name);
                        Log.d("ProviderActivityQuery", "book author : " + author);
                        Log.d("ProviderActivityQuery", "book pages : " + pages);
                        Log.d("ProviderActivityQuery", "book price : " + price);
                    }
                    cursor.close();
                }
            }
        });
        ((Button) findViewById(R.id.update_data)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //更新数据
                Uri uri = Uri.parse("content://com.example.owen.stud.provider/book/" + newId);
                ContentValues values = new ContentValues();
                values.put("name", "A Storm of Swords");
                values.put("pages", 1216);
                values.put("price", 55.55);
                getContentResolver().update(uri, values, null, null);
            }
        });
        ((Button) findViewById(R.id.delete_data)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //删除数据
                Uri uri = Uri.parse("content://com.example.owen.stud.provider/book/" + newId);
                getContentResolver().delete(uri, null, null);
            }
        });
    }
}
