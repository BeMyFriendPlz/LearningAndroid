package com.example.learningandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningandroid.model.NhanVien;
import com.example.learningandroid.model.NhanVienAdapter;

public class Class_Excer_1_Activity extends AppCompatActivity implements NhanVienAdapter.NhanVienListener {
    private EditText etID, etName;
    private RadioButton nu, nam;
    private Button add, erase;
    private RecyclerView rv;
    NhanVienAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_excer_1);
        initView();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVien nv = new NhanVien();
                nv.setMa(etID.getText().toString());
                nv.setTen(etName.getText().toString());
                nv.setGioiTinh(nam.isChecked());
                nv.setCheck(false);
                adapter.add(nv);
            }
        });
        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.erase();
                erase.setEnabled(false);
            }
        });
    }

    private void initView() {
        etID = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        nu = findViewById(R.id.nu);
        nam = findViewById(R.id.nam);
        add = findViewById(R.id.add);
        erase = findViewById(R.id.erase);
        erase.setEnabled(false);
        rv = findViewById(R.id.rv);
        adapter = new NhanVienAdapter(this);
        adapter.setListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
    }

    @Override
    public void OnCheckListener(View view, int position) {
        if (adapter.isNVCheck()) {
            erase.setEnabled(true);
        } else {
            erase.setEnabled(false);
        }
    }
}