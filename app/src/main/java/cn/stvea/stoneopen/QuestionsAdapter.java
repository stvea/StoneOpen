/*
 * Copyright (c) 2018/12/18
 *  By 葛超2016020900030 徐慧东2016020800168
 *  @https://STVEA.cn
 */

package cn.stvea.stoneopen;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class QuestionsAdapter extends BaseAdapter {
    private List<Questions> mList;
    private LayoutInflater mInflater;

    public QuestionsAdapter(Context context,List<Questions> mList) {
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
        Questions questions = mList.get(position);
        titleView.setText(questions.questions_title);
        return convertView;
    }
}
