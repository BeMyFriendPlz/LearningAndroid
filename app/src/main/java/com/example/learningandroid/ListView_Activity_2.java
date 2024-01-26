package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.learningandroid.model.Technology;
import com.example.learningandroid.model.TechnologyAdapter;

public class ListView_Activity_2 extends AppCompatActivity {
    private ListView listView;
    private TechnologyAdapter adapter;
    private Technology[] lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view2);
        listView = findViewById(R.id.lv);
        initData();
        adapter = new TechnologyAdapter(getApplicationContext(), lst);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Doi tat ca ve mau mac dinh
                for (int i = 0; i < listView.getAdapter().getCount(); i++) {
                    listView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                }
                listView.getChildAt(position).setBackgroundColor(Color.GREEN);
                Technology t = adapter.getItem(position);
                Toast.makeText(ListView_Activity_2.this, t.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        Integer[] imgs = {R.drawable.android_logo, R.drawable.ios_logo,
                R.drawable.blackberry_logo, R.drawable.windows_phone_logo};
        String[] names = {"Android", "Ios", "Blackberry", "Windows Phone"};
        String[] subs = {"Sub Android", "Sub Ios", "Sub Blackberry", "Sub Windows Phone"};
        String[] dess = {"MT Android", "MT Ios", "MT Blackberry", "MT Windows Phone"};
        lst = new Technology[imgs.length];
        for (int i = 0; i < imgs.length; i++) {
            lst[i] = new Technology(imgs[i], names[i], subs[i], dess[i]);
        }
    }
}