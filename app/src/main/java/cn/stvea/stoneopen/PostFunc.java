/*
 * Copyright (c) 2018/12/13
 *  By 葛超2016020900030 徐慧东2016020800168
 *  @https://STVEA.cn
 */

package cn.stvea.stoneopen;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PostFunc extends AsyncTask<Void, Integer, Integer> {
    private Context context;
    private String url;
    private String postValue;
    private ProgressBar progressBar;


    public PostFunc(Context context, String url, String postValue, ProgressBar progressBar) {
        this.context = context;
        this.url = url;
        this.postValue = postValue;

        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(context,"正在登陆",Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        HttpURLConnection connection;
        InputStream is;
        int res = 123;//connection.getResponseCode();

        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            //connection.connect();
            res = connection.getResponseCode();
            return res;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        Toast.makeText(context,String.valueOf(integer),Toast.LENGTH_SHORT).show();
    }
}
