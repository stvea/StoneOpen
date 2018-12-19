/*
 * Copyright (c) 2018/12/19
 *  By 葛超2016020900030 徐慧东2016020800168
 *  @https://STVEA.cn
 */

package cn.stvea.stoneopen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class QuestionsDetailActivity extends AppCompatActivity {

    private int questionID;
    private TextView tvText;
    private TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        tvTitle = (TextView)findViewById(R.id.questionsTitle);
        tvText = (TextView)findViewById(R.id.questionsText);

        Intent intent = getIntent();
        int id  = intent.getIntExtra("id",1);
        String content = "id="+id;
//        Handler handler = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                Questions questions;
//                super.handleMessage(msg);
//                Log.d("提示",msg.obj.toString());
//                String jsonArray = "[{\"id\":1,\"introduce\":\"asd\",\"title\":\"asddfdgfd\",\"like\":12,\"text\":\"a啊啊实打实大苏打啊是大阿三\"}]";
//                Gson gson = new Gson();
//                questions = gson.fromJson(msg.obj.toString(),Questions.class);
//            }
//        };
//        new PostFunc("http://192.168.31.154:80/getQuestions.php",content,handler).execute();
        Questions questions;
        String jsonArray = "{\"id\":1,\"introduce\":\"asd\",\"title\":\"asddfdgfd\",\"likes\":12,\"texts\":\"啊啊实打实大苏打啊是大阿三\"}";
        Gson gson = new Gson();
        questions = gson.fromJson(jsonArray,Questions.class);
        tvTitle.setText(questions.title);
        tvText.setText(questions.getTexts());


    }
}
