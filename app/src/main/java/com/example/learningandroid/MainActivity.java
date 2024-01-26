package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.excer_10);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.actv);
        String[] lst = getResources().getStringArray(R.array.city);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lst);
        autoCompleteTextView.setAdapter(adapter);

        MultiAutoCompleteTextView multiAutoCompleteTextView = findViewById(R.id.mactv);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
//        sp2 = findViewById(R.id.s2);
//        String lst[] = {"PTIT", "HUST", "FPT", "NEU"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item, lst);
//        sp2.setAdapter(adapter);
//
//        sp1 = findViewById(R.id.s1);
//        String list[] = getResources().getStringArray(R.array.countries);
//        ArrayAdapter<String> ad = new ArrayAdapter<>(this, R.layout.item, list);
//        sp1.setAdapter(ad);

    }
}