/*
 * Copyright (c) 2018/12/22
 *  By 葛超2016020900030 徐慧东2016020800168
 *  @https://STVEA.cn
 */

package cn.stvea.stoneopen;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button loginBtn;
    private ProgressBar progressBar;
    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        loginBtn = (Button)findViewById(R.id.login);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userinfo = "username="+username.getText().toString()+"&password="+password.getText().toString();
                Toast.makeText(RegisterActivity.this,"正在注册",Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.VISIBLE);

                Handler handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        progressBar.setVisibility(View.INVISIBLE);
                        if(msg.obj==null){
                            Toast.makeText(RegisterActivity.this,"网络错误！",Toast.LENGTH_SHORT).show();
                        }else{
                                Intent intent = new Intent();
                                intent.setClass(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent);
                        }
                    }
                };
                Log.d("userinfo",userinfo);
                new PostFunc(getString(R.string.host_name)+"register.php",userinfo,handler).execute();//http://192.168.31.154:80/login.php


                //Toast.makeText(LoginActivity.this,"asd",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
