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
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    private TextView tvTitle;
    private SwipeRefreshLayout refreshLayout;
    private ListView listView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView) view.findViewById(R.id.questionsMain);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshLayout);
        init();


    }
    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if(this.getView()!=null){
            this.getView().setVisibility(menuVisible?View.VISIBLE:View.GONE);
        }
    }
    public void init(){
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                List<Questions> questionsList = new ArrayList<>();
                super.handleMessage(msg);
                if(msg.obj==null){
                    Toast.makeText(getContext(),"网络错误！",Toast.LENGTH_SHORT).show();
                }else{
                    Log.d("提示",msg.obj.toString());
                    //String jsonArray = "[{\"id\":0,\"introduce\":\"asd\",\"title\":\"asddfdgfd\",\"likes\":12},{\"id\":1,\"introduce\":\"asd\",\"title\":\"asddfdgfd\",\"likes\":12},{\"id\":2,\"introduce\":\"asd\",\"title\":\"这里是啊啊是大\",\"likes\":12}]";
                    Gson gson = new Gson();
                    questionsList = gson.fromJson(msg.obj.toString(),new TypeToken<List<Questions>>(){}.getType());
                    listView.setAdapter(new QuestionsAdapter(getContext(),questionsList));
                }
            }
        };
        new PostFunc(getString(R.string.host_name)+"questions.php","id=-1",handler).execute();
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeResources(R.color.colorAccent,R.color.colorAccent, R.color.colorAccent,R.color.colorPrimary); // 进度动画颜色

    }

    @Override
    public void onRefresh() {
        init();
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false); // 是否显示刷新进度;false:不显示
            }
        },3000);
    }
}
