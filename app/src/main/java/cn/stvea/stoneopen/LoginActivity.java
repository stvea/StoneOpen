package cn.stvea.stoneopen;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
                new PostFunc(LoginActivity.this,"http://192.168.31.154:80/login.php","asdasd",progressBar,"username=stvea&password=123").execute();
                //Toast.makeText(LoginActivity.this,"asd",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
