package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String[] names = {
            "yasumago", "mihara", "本日のコロナ状況",
            "matsuura", "sekiguchi", "park",
            "露、戦争反対の声", "osaka", "nagoya", "hokkaido"
    };

    // それぞれの画像ファイルをdarawableに入れます
    // ArrayListにコピーするためintからInteger型にしました
    private static final Integer[] photos = {
            R.drawable.yasumago, R.drawable.mihara,
            R.drawable.fujisawa, R.drawable.matsuura,
            R.drawable.sekiguchi, R.drawable.park,
            R.drawable.putin, R.drawable.osaka,
            R.drawable.nagoya, R.drawable.hokkaido
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager rLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(rLayoutManager);


        // 配列をArrayListにコピー
        List<String> itemNames = new ArrayList<>(Arrays.asList(names));
        List<Integer> itemImages = new ArrayList<>(Arrays.asList(photos));

        List<String> itemEmails = new ArrayList<>();

        for(String s : itemNames){
            String str = String.format(Locale.JAPANESE, "ニュース内容が入ります", s);
            itemEmails.add(str);
        }

        MyAdapter adapter = new MyAdapter(itemImages, itemNames, itemEmails);
        recyclerView.setAdapter(adapter);

    }}