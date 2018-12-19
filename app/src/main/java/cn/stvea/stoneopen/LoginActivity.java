package cn.stvea.stoneopen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button loginBtn;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        loginBtn = (Button)findViewById(R.id.login);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userinfo = "username="+username.getText().toString()+"&password="+password.getText().toString();
                Toast.makeText(LoginActivity.this,"正在登陆",Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.VISIBLE);

                Handler handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        progressBar.setVisibility(View.INVISIBLE);
                        if(msg.obj.equals("fail")){
                            Toast.makeText(LoginActivity.this,"用户名或密码错误！",Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent = new Intent();
                            intent.setClass(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }
                };
                Log.d("userinfo",userinfo);
                new PostFunc("http://192.168.31.154:80/login.php",userinfo,handler).execute();


                //Toast.makeText(LoginActivity.this,"asd",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
