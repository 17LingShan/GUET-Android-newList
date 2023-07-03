package com.example.newlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static final String NEWS_ID = "news_id";
    private List<News> newsList = new ArrayList <>();
    private static final String NEWS_TITLE = "news_title";
    private static final String NEWS_AUTHOR = "news_author";
    private String[] titles = null;
    private String[] authors = null;
    private NewsAdapter newsAdapter = null;
    private RecyclerView recyclerView;

    private List<Map<String, String>> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        titles = getResources().getStringArray(R.array.titles);
//        authors = getResources().getStringArray(R.array.authors);
        recyclerView = findViewById(R.id.lv_news_list);
        initData();

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                MainActivity.this, android.R.layout.simple_list_item_1, titles);
//
//        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this , dataList , android.R.layout.simple_list_item_2 , new String[]{NEWS_TITLE , NEWS_AUTHOR}, new int[]{android.R.id.text1 , android.R.id.text2});
//
//        NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this, R.layout.list_item, newsList);
//
//        ListView lvNewsList = findViewById(R.id.lv_news_list);
//        lvNewsList.setAdapter(adapter);
//        lvNewsList.setAdapter(simpleAdapter);
//        lvNewsList.setAdapter(newsAdapter);
        newsAdapter = new NewsAdapter(MainActivity.this, R.layout.list_item, newsList);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(newsAdapter);
    }

    private void initData() {
        int length;
        titles = getResources().getStringArray(R.array.titles);
        authors = getResources().getStringArray(R.array.authors);
        TypedArray images = getResources().obtainTypedArray(R.array.images);

        if (titles.length > authors.length) {
            length = authors.length;
        } else {
            length = titles.length;
        }

        for (int i = 0; i < length; i++) {
            Map map = new HashMap();
            map.put(NEWS_TITLE, titles[i]);
            map.put(NEWS_AUTHOR, authors[i]);

            dataList.add(map);

            News news = new News();
            news.setTitle(titles[i]);
             news.setAuthor(authors[i]);
            news.setImageId(images.getResourceId(i, 0));

             newsList.add(news);
        }
    }
    public class News {
        private String mTitle;
        private String mAuthor;
        private String mContent;
        private int mImageId;

        public String getTitle() {
            return mTitle;
        }
        public String getAuthor() {
            return mAuthor;
        }
        public String getContent() {
            return mContent;
        }
        public Integer getImageId() {
            return mImageId;
        }
        public void setTitle(String title) {
            this.mTitle = title;
        }
        public void setAuthor(String author) {
            this.mAuthor = author;
        }
        public void setContent(String content) {
            this.mContent = content;
        }
        public void setImageId(Integer imageId) {
            this.mImageId = imageId;
        }
    }
}