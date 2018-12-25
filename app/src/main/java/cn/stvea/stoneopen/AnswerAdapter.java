/*
 * Copyright (c) 2018/12/24
 *  By 葛超2016020900030 徐慧东2016020800168
 *  @https://STVEA.cn
 */

package cn.stvea.stoneopen;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class AnswerAdapter extends BaseAdapter {
    private Context context;
    private List<Answer> mList;
    private LayoutInflater mInflater;

    public AnswerAdapter(Context context, List<Answer> mList) {
        this.context = context;
        this.mList = mList;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.listview_answer,null);
        }


        TextView texts = (TextView)convertView.findViewById(R.id.answerTexts);
        final Button likes = (Button)convertView.findViewById(R.id.Like);

        final Answer answer = mList.get(position);
        texts.setText(answer.getTexts());
        likes.setText("Likes:"+answer.getLikes());
        likes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Handler handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        if(!msg.obj.toString().isEmpty()){
                            Toast.makeText(context,"点赞成功！",Toast.LENGTH_SHORT).show();

                        }
                    }
                };

                Log.d("ipo",context.getString(R.string.host_name)+"likes.php");
                new PostFunc(context.getString(R.string.host_name)+"likes.php","id="+answer.getId(),handler).execute();
            }
        });
        return convertView;
    }
}
