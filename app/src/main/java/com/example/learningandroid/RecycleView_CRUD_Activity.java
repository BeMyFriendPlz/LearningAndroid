package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learningandroid.model.Cat_crud;
import com.example.learningandroid.model.Cat_crudApdater;
import com.example.learningandroid.model.SpinnerAdapter;

public class RecycleView_CRUD_Activity extends AppCompatActivity implements Cat_crudApdater.Cat_crubItemListener {
    private Spinner sp;
    private SpinnerAdapter adapter;
    private EditText et1, et2, et3;
    private Button bt1, bt2;
    private RecyclerView rv;
    private Cat_crudApdater cat_crudApdater;
    private int curPosition;
    private int[] imgs = {R.drawable.img_1, R.drawable.img_2, R.drawable.img_3,
            R.drawable.img_4, R.drawable.img_5, R.drawable.img_6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view_crud);
        initView();
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cat_crud cat = new Cat_crud();
                try {
                    int img = Integer.parseInt(sp.getSelectedItem().toString());
                    String name = et1.getText().toString();
                    double price = Double.parseDouble(et2.getText().toString());
                    String description = et3.getText().toString();
                    cat.setImg(img);
                    cat.setName(name);
                    cat.setPrice(price);
                    cat.setDescription(description);
                    cat_crudApdater.add(cat);
                } catch (NumberFormatException e) {
                    Toast.makeText(RecycleView_CRUD_Activity.this, "Nhập lại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cat_crud cat = new Cat_crud();
                try {
                    int img = Integer.parseInt(sp.getSelectedItem().toString());
                    String name = et1.getText().toString();
                    double price = Double.parseDouble(et2.getText().toString());
                    String description = et3.getText().toString();
                    cat.setImg(img);
                    cat.setName(name);
                    cat.setPrice(price);
                    cat.setDescription(description);
                    cat_crudApdater.update(cat, curPosition);
                    bt1.setEnabled(true);
                    bt2.setEnabled(false);
                } catch (NumberFormatException e) {
                    Toast.makeText(RecycleView_CRUD_Activity.this, "Nhập lại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        sp = findViewById(R.id.sp);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        rv = findViewById(R.id.rv);
        adapter = new SpinnerAdapter(this);
        sp.setAdapter(adapter);
        cat_crudApdater = new Cat_crudApdater(this);
        cat_crudApdater.setListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rv.setLayoutManager(manager);
        rv.setAdapter(cat_crudApdater);
        bt2.setEnabled(false);
    }

    @Override
    public void onItemClick(View view, int position) {
        bt1.setEnabled(false);
        bt2.setEnabled(true);
        curPosition = position;
        Cat_crud cat = cat_crudApdater.getItem(position);
        for (int i = 0; i < imgs.length; i++) {
            if (cat.getImg() == imgs[i]) {
                sp.setSelection(i);
                break;
            }
        }
        et1.setText(cat.getName());
        et2.setText(cat.getPrice()+"");
        et3.setText(cat.getDescription());
    }
}