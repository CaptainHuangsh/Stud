package com.example.owen.stud.contentProvider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by owen on 2017/5/21.
 * 自定义ContentProvider
 */

public class MyProvider extends ContentProvider {

    public static final int TABLE1_DIR = 0;
    public static final int TABLE1_ITEM = 1;
    public static final int TABLE2_DIR = 2;
    public static final int TABLE2_ITEM = 3;

    private static UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.owen.stud.provider","table1",TABLE1_DIR);
        uriMatcher.addURI("com.example.owen.stud.provider","table1/#",TABLE1_ITEM);
        uriMatcher.addURI("com.example.owen.stud.provider","table2",TABLE2_DIR);
        uriMatcher.addURI("com.example.owen.stud.provider","table2/#",TABLE2_ITEM);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        switch (uriMatcher.match(uri)){
            case TABLE1_DIR:
                //查询table1表中的所有数据
                break;
            case TABLE1_ITEM:
                //查询table1表中的所有单条数据
                break;
            case TABLE2_DIR:
                break;
            case TABLE2_ITEM:
                break;
            default:
                break;

        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)){
            case TABLE1_DIR:
                return "nvd.android.cursor.dir/vnd.com.example.owen.stud" +
                        ".provider.table1";//return不需要break？
            case TABLE1_ITEM:
                return "nvd.android.cursor.item/vnd.com.example.owen.stud" +
                        ".provider.table1";
            case TABLE2_DIR:
                return "nvd.android.cursor.dir/vnd.com.example.owen.stud" +
                        ".provider.table2";//return不需要break？
            case TABLE2_ITEM:
                return "nvd.android.cursor.item/vnd.com.example.owen.stud" +
                        ".provider.table2";
            default:
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}