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
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private TextView tvTitle;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                ListView listView;
                List<Questions> questionsList = new ArrayList<>();
                super.handleMessage(msg);
                Log.d("提示",msg.obj.toString());
                String jsonArray = "[{\"id\":1,\"introduce\":\"asd\",\"title\":\"asddfdgfd\",\"likes\":12},{\"id\":2,\"introduce\":\"asd\",\"title\":\"这里是啊啊是大\",\"likes\":12}]";
                Gson gson = new Gson();
                questionsList = gson.fromJson(jsonArray,new TypeToken<List<Questions>>(){}.getType());
                listView = (ListView) view.findViewById(R.id.questionsMain);
                listView.setAdapter(new QuestionsAdapter(getContext(),questionsList));
            }
        };
        new PostFunc("http://192.168.31.154:80/questions.php","count=1",handler).execute();

    }
    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if(this.getView()!=null){
            this.getView().setVisibility(menuVisible?View.VISIBLE:View.GONE);
        }
    }
}
