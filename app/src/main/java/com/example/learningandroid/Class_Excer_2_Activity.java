package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.learningandroid.model.Stadium;
import com.example.learningandroid.model.StadiumAdapter;

import java.util.ArrayList;
import java.util.List;

public class Class_Excer_2_Activity extends AppCompatActivity implements StadiumAdapter.StadiumListener {
    private RecyclerView rv;
    private StadiumAdapter adapter;
    private List<Stadium> getList () {
        List<Stadium> lst = new ArrayList<>();
        lst.add(new Stadium(R.drawable.img_1, "Sân Cường Quốc", "28 Phùng Khoang, Thanh Xuân, HN"));
        lst.add(new Stadium(R.drawable.img_2, "Sân Cầu Voi", "Số 8, Bốt Nước, Hàng Đậu"));
        lst.add(new Stadium(R.drawable.img_3, "Sân Fusal", "Số 9, Dịch Vọng, HN"));
        lst.add(new Stadium(R.drawable.img_4, "Sân Thành Phúc", "108 Thanh Xuân, HN"));
        lst.add(new Stadium(R.drawable.img_5, "Sân Viettel", "Bùi Xương Trạch, Thanh Xuân, HN"));
        return lst;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_excer_2);
        rv = findViewById(R.id.rv);
        adapter = new StadiumAdapter(this, getList());
        adapter.setListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
    }

    @Override
    public void OnClickListener(View view, int position) {
        Stadium stadium = getList().get(position);
        Toast.makeText(this, stadium.getName(), Toast.LENGTH_SHORT).show();
    }
}