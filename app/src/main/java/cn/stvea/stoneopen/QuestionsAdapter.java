/*
 * Copyright (c) 2018/12/18
 *  By 葛超2016020900030 徐慧东2016020800168
 *  @https://STVEA.cn
 */

package cn.stvea.stoneopen;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class QuestionsAdapter extends BaseAdapter {
    private Context context;
    private List<Questions> mList;
    private LayoutInflater mInflater;

    public QuestionsAdapter(Context context,List<Questions> mList) {
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
            convertView = mInflater.inflate(R.layout.listview_questions,null);
        }


        TextView titleView = (TextView)convertView.findViewById(R.id.questionsTitle);
        TextView introduceView = (TextView)convertView.findViewById(R.id.questionsIntroduce);
        TextView likeView = (TextView)convertView.findViewById(R.id.questionsLike);

        final Questions questions = mList.get(position);
        titleView.setText(questions.title);
        introduceView.setText(questions.introduce);
        likeView.setText("Likes"+questions.likes);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context,QuestionsDetailActivity.class);
                intent.putExtra("id",questions.id);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
