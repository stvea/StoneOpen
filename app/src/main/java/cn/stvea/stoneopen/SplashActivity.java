package cn.stvea.stoneopen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent loginIntent = new Intent();
                loginIntent.setClass(SplashActivity.this,LoginActivity.class);
                startActivity(loginIntent);
            }
        };
        handler.postDelayed(runnable,1000);
    }
}
