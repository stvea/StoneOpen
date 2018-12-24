/*
 * Copyright (c) 2018/12/19
 *  By 葛超2016020900030 徐慧东2016020800168
 *  @https://STVEA.cn
 */

package cn.stvea.stoneopen;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class AddQuestionsFragment extends Fragment {
    private EditText etTitle;
    private EditText etText;
    private EditText etIntroduce;
    private Button btnAdd;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etTitle = (EditText)view.findViewById(R.id.etTitle);
        etText = (EditText)view.findViewById(R.id.etText);
        etIntroduce= (EditText)view.findViewById(R.id.etIntroduce);
        btnAdd = (Button)view.findViewById(R.id.button);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content= "title="+etTitle.getText().toString()+"&texts="+etText.getText().toString()+"&introduce="+etIntroduce.getText().toString();
                Handler handler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        List<Questions> questionsList = new ArrayList<>();
                        super.handleMessage(msg);
                        if(msg.obj==null){
                            Toast.makeText(getContext(),"网络错误！",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getContext(),"提问成功！",Toast.LENGTH_SHORT).show();
                        }
                    }
                };
                new PostFunc(getString(R.string.host_name)+"add.php",content,handler).execute();
            }
        });

    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if(this.getView()!=null){
            this.getView().setVisibility(menuVisible?View.VISIBLE:View.GONE);
        }
    }
}
