package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner sp1, sp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widgets_excer);
        sp2 = findViewById(R.id.s2);
        String lst[] = {"PTIT", "HUST", "FPT", "NEU"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item, lst);
        sp2.setAdapter(adapter);

        sp1 = findViewById(R.id.s1);
        String list[] = getResources().getStringArray(R.array.countries);
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, R.layout.item, list);
        sp1.setAdapter(ad);
    }
}