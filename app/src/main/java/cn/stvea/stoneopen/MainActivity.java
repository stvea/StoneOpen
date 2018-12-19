package cn.stvea.stoneopen;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FrameLayout homeContent;
    private RadioGroup radioGroup;
    private RadioButton rbHome,rbAdd;
    private HomeFragment homeFragment;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        radioGroup.check(R.id.radioHome);
    }

    protected void initView(){
        homeContent = (FrameLayout)findViewById(R.id.homeContent);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        rbAdd = (RadioButton)findViewById(R.id.radioAdd);
        rbHome = (RadioButton)findViewById(R.id.radioHome);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index=0;
                switch (checkedId){
                    case R.id.radioHome:
                        index = 0;
                        break;
                    case R.id.radioAdd:
                        index = 1;
                        break;
                }
                Fragment fragment = (Fragment)adapter.instantiateItem(homeContent,index);
                adapter.setPrimaryItem(homeContent,0,fragment);
                adapter.finishUpdate(homeContent);
            }
        });
    }
    FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position){
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new AddQuestionsFragment();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    };
}
