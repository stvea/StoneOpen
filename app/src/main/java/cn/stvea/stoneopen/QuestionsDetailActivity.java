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
    private Questions question;
    private TextView tvText;
    private TextView tvTitle;
    private ListView listView;
    private Button addAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        tvTitle = (TextView)findViewById(R.id.questionsTitle);
        tvText = (TextView)findViewById(R.id.questionsText);
        listView = (ListView)findViewById(R.id.answerMain);
        addAnswer = (Button)findViewById(R.id.addAnswer);
        final Intent intent = getIntent();
        final int id  = intent.getIntExtra("id",1);
        String content = "id="+id;

        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Log.d("提示",msg.obj.toString());
                //String jsonArray = "{\"id\":1,\"introduce\":\"asd\",\"title\":\"asddfdgfd\",\"likes\":12,\"texts\":\"a啊啊实打实大苏打啊是大阿三\"}]";
                //[{"id":6,"title":"123123","texts":"123123","likes":0,"introduce":"asdasd"}]
                Gson gson = new Gson();
                question = gson.fromJson(msg.obj.toString(),Questions.class);
                tvTitle.setText(question.title);
                tvText.setText(question.getTexts());
            }
        };
        new PostFunc(getString(R.string.host_name)+"questions.php",content,handler).execute();

        Handler handlerAnswer = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                List<Answer> answerList = new ArrayList<>();
                super.handleMessage(msg);
                Log.d("提示answer",msg.obj.toString());
                if(!msg.obj.toString().isEmpty()){
                    Gson gson = new Gson();
                    answerList = gson.fromJson(msg.obj.toString(),new TypeToken<List<Answer>>(){}.getType());
                    listView.setAdapter(new AnswerAdapter(QuestionsDetailActivity.this,answerList));
                }
            }
        };
        new PostFunc(getString(R.string.host_name)+"answer.php",content,handlerAnswer).execute();
        addAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.setClass(QuestionsDetailActivity.this,AddAnswerActivity.class);
                intent1.putExtra("qid",id);
                startActivity(intent1);
            }
        });
    }
}
