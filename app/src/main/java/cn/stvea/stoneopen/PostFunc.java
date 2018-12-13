/*
 * Copyright (c) 2018/12/13
 *  By 葛超2016020900030 徐慧东2016020800168
 *  @https://STVEA.cn
 */

package cn.stvea.stoneopen;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class PostFunc extends AsyncTask<Void, Integer, Integer> {
    private Context context;
    private String url;
    private String postValue;
    private ProgressBar progressBar;
    private String content;

    public PostFunc(Context context, String url, String postValue, ProgressBar progressBar,String content) {
        this.context = context;
        this.url = url;
        this.postValue = postValue;
        this.content = content;
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

        try {
            //url = "http://192.168.31.154:80/login.php";
            connection = (HttpURLConnection) new URL(url).openConnection();
            Log.d("url :","url="+url);

            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Connection","Keep-Alive");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.connect();
            DataOutputStream dos= new DataOutputStream(connection.getOutputStream());
            String postContent = content;
            dos.write(postContent.getBytes());
            dos.flush();
            dos.close();
            int respondCode = connection.getResponseCode();
            Log.d("response code:","r="+respondCode);
            String type = connection.getContentType();
            Log.d("type", "type="+type);
            // 获取返回内容的字符编码
            String encoding = connection.getContentEncoding();
            Log.d("encoding", "encoding="+encoding);
            // 获取返回内容长度，单位字节
            int length = connection.getContentLength();
            Log.d("length", "length=" + length);
            Map<String, List<String>> map = connection.getHeaderFields();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        Toast.makeText(context,String.valueOf(integer),Toast.LENGTH_SHORT).show();
    }
}
