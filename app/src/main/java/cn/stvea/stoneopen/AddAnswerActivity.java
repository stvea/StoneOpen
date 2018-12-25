/*
 * Copyright (c) 2018/12/24
 *  By 葛超2016020900030 徐慧东2016020800168
 *  @https://STVEA.cn
 */

package cn.stvea.stoneopen;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class AddAnswerActivity extends AppCompatActivity {
    private EditText edAnswer;
    private Button btnAdd;
    private String qid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_answer);
        edAnswer = (EditText)findViewById(R.id.editText);
        btnAdd = (Button)findViewById(R.id.button);

        Intent intent = getIntent();
        qid  = "qid="+intent.getIntExtra("qid",1);//+"&texts="+edAnswer.getText().toString();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qid = qid + "&texts="+edAnswer.getText().toString();
                Log.d("!!!",qid);
                Handler handler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        if(!msg.obj.toString().isEmpty()){
                            Toast.makeText(AddAnswerActivity.this,"添加成功！",Toast.LENGTH_SHORT).show();
                            AddAnswerActivity.this.finish();
                        }

                    }
                };
                new PostFunc(getString(R.string.host_name)+"addAnswer.php",qid,handler).execute();
            }
        });

    }
}
