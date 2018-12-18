package cn.stvea.stoneopen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView listView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Questions> questionsList = new ArrayList<>();
        for(int i=0;i<20;i++){
            questionsList.add(new Questions("asd"));
        }
        listView = (ListView)findViewById(R.id.questionsMain);
        listView.setAdapter(new QuestionsAdapter(this,questionsList));

    }
}
