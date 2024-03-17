package com.example.learningandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.learningandroid.model.FragmentA;
import com.example.learningandroid.model.FragmentB;

public class Dynamic_Fragment_Activity extends AppCompatActivity implements View.OnClickListener {
    private Button bt1, bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_fragment_activity);
        bt1 = findViewById(R.id.fragA);
        bt2 = findViewById(R.id.fragB);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment;
        switch (v.getId()) {
            case R.id.fragA:
                fragment = new FragmentA();
                transaction.add(R.id.fl, fragment);
                break;
            case R.id.fragB:
                fragment = new FragmentB();
                transaction.add(R.id.fl, fragment);
                break;
        }
        transaction.commit();
    }
}