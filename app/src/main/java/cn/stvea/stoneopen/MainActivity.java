package cn.stvea.stoneopen;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                ListView listView;
                List<Questions> questionsList = new ArrayList<>();
                super.handleMessage(msg);
                Log.d("提示",msg.obj.toString());
                String jsonArray = "[{\"id\":123,\"introduce\":\"asd\",\"title\":\"asddfdgfd\",\"like\":12},{\"id\":123,\"introduce\":\"asd\",\"title\":\"这里是啊啊是大\",\"like\":12}]";
                Gson gson = new Gson();
                questionsList = gson.fromJson(jsonArray,new TypeToken<List<Questions>>(){}.getType());
                listView = (ListView)findViewById(R.id.questionsMain);
                listView.setAdapter(new QuestionsAdapter(MainActivity.this,questionsList));
                //String[] strings = gson.fromJson(msg.obj.toString(),String[].class);
//                for (String string : strings) {
//                    Log.d("Gson",string);
//                }
                //Log.d("asd",questions.toString());
            }
        };
        new PostFunc("http://192.168.31.154:80/questions.php","count=1",handler).execute();


    }
}
