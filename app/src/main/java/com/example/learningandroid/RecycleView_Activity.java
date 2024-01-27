package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.learningandroid.model.Cat;
import com.example.learningandroid.model.CatAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecycleView_Activity extends AppCompatActivity implements CatAdapter.CatItemListener{
    private RecyclerView rv;
    private CatAdapter ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view);
        rv = findViewById(R.id.rv);
        ca = new CatAdapter(getList());
        ca.setCatItemListener(this);
//        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        rv.setLayoutManager(manager);
        rv.setAdapter(ca);
    }

    private List<Cat> getList(){
        List<Cat> lst = new ArrayList<>();
        lst.add(new Cat(R.drawable.img_1, "OnePunchMan 1"));
        lst.add(new Cat(R.drawable.img_2, "OnePunchMan 2"));
        lst.add(new Cat(R.drawable.img_3, "OnePunchMan 3"));
        lst.add(new Cat(R.drawable.img_4, "OnePunchMan 4"));
        lst.add(new Cat(R.drawable.img_5, "OnePunchMan 5"));
        lst.add(new Cat(R.drawable.img_6, "OnePunchMan 6"));
        return lst;
    }

    @Override
    public void onItemClick(View view, int position) {
        Cat cat = getList().get(position);
        Toast.makeText(this, cat.getName(), Toast.LENGTH_SHORT).show();
    }
}