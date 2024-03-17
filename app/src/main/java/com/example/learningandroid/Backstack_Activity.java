package com.example.learningandroid;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.learningandroid.model.FragmentA;
import com.example.learningandroid.model.FragmentB;
import com.example.learningandroid.model.FragmentC;

public class Backstack_Activity extends AppCompatActivity {
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.backstack);
        manager = getSupportFragmentManager();
    }

    public void add(Fragment fragment, String tag, String name) {
        transaction = manager.beginTransaction();
        transaction.add(R.id.frame, fragment, tag);
        transaction.addToBackStack(name);
        transaction.commit();
    }

    public void addA(View view) {
        Fragment fragment = new FragmentA();
        add(fragment, "fragA", "fa");
    }

    public void addB(View view) {
        Fragment fragment = new FragmentB();
        add(fragment, "fragB", "fb");
    }

    public void addC(View view) {
        Fragment fragment = new FragmentC();
        add(fragment, "fragC", "fc");
    }

    public void remove(String tag, String name) {
        transaction = manager.beginTransaction();
        Fragment fragment = manager.findFragmentByTag(tag);
        if (fragment != null) {
            transaction.remove(fragment);
            transaction.addToBackStack(name);
        }
        transaction.commit();
    }

    public void removeA(View view) {
        remove("fragA", "fa");
    }

    public void removeB(View view) {
        remove("fragB", "fb");
    }

    public void removeC(View view) {
        remove("fragC", "fc");
    }

    public void back(View view) {
        manager.popBackStack();
    }

    public void pop(View view) {
        manager.popBackStack("fa", 0);
    }

//    @Override
//    public void onBackPressed() {
//        if (manager.getBackStackEntryCount() > 0) {
//            manager.popBackStack();
//        }
//        super.onBackPressed();
//    }
}