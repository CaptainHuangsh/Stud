package com.example.owen.stud.service.AsyncTask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.owen.stud.fresco.MyApplication;

/**
 * Created by owen on 2017/5/1.
 */

public class DownloadTask extends AsyncTask<Void, Integer, Boolean> {
    ProgressDialog progressDialog;

    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            while (true) {
                int downloadPercent = doDownload();
                publishProgress(downloadPercent);
                if (downloadPercent >= 100) {
                    break;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private int doDownload() {
        return 0;
    }

    @Override
    protected void onPreExecute() {
        progressDialog.show();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        //在这里更新下载速度
        progressDialog.setMessage("Downloaded "+ values[0] + "%");
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        progressDialog.dismiss();//关闭进度对话框
        //在这里显示下载结果
        if(aBoolean){
            Toast.makeText(MyApplication.context,"Download succeeded",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MyApplication.context,"Download failed",Toast.LENGTH_SHORT).show();
        }
    }
}
