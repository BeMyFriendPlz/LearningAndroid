package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView_Activity extends AppCompatActivity {
    private ListView lv;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        lv = findViewById(R.id.lv);
        initListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = adapter.getItem(position).toString();
                Toast.makeText(ListView_Activity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initListView() {
        String[] lst = getResources().getStringArray(R.array.tech);
        adapter = new ArrayAdapter<>(this, R.layout.item, lst);
        lv.setAdapter(adapter);
    }
}