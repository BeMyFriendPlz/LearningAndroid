package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.learningandroid.model.CongViec;
import com.example.learningandroid.model.CongViecAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Test_2_Activity extends AppCompatActivity implements View.OnClickListener, CongViecAdapter.CongViecListener {
    private EditText name, content, date;
    private RadioButton boy, girl;
    private Button them, sua;
    private RecyclerView rv;
    private SearchView sv;
    private CongViecAdapter adapter;
    private int curPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_2);
        initView();
        date.setOnClickListener(this);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CongViec cv = new CongViec();
                cv.setName(name.getText().toString());
                cv.setContent(content.getText().toString());
                cv.setDate(date.getText().toString());
                cv.setGender(boy.isChecked());
                adapter.add(cv);
            }
        });
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CongViec cv = new CongViec();
                cv.setName(name.getText().toString());
                cv.setContent(content.getText().toString());
                cv.setDate(date.getText().toString());
                cv.setGender(boy.isChecked());
                adapter.update(cv, curPosition);
                sua.setEnabled(false);
                them.setEnabled(true);
            }
        });
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<CongViec> filterLst = new ArrayList<>();
                for(CongViec cv : adapter.getBackUpLst()) {
                    if (cv.getName().toLowerCase().contains(newText.toLowerCase())) {
                        filterLst.add(cv);
                    }
                }
                adapter.setFilterLst(filterLst);
                if (filterLst.isEmpty()) {
                    Toast.makeText(Test_2_Activity.this, "Not Found!!!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    private void initView() {
        name = findViewById(R.id.et1);
        content = findViewById(R.id.et2);
        date = findViewById(R.id.et3);
        boy = findViewById(R.id.nam);
        girl = findViewById(R.id.nu);
        them = findViewById(R.id.them);
        sua = findViewById(R.id.sua);
        sua.setEnabled(false);
        rv = findViewById(R.id.rv);
        adapter = new CongViecAdapter(this);
        adapter.setListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
        sv = findViewById(R.id.sv);
    }

    @Override
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date.setText(dayOfMonth + "/" + month + "/" + year);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_WEEK));
        dialog.show();
    }

    @Override
    public void OnClickListener(View view, int position) {
        them.setEnabled(false);
        sua.setEnabled(true);
        curPosition = position;
        CongViec congViec = adapter.getItem(position);
        name.setText(congViec.getName());
        content.setText(congViec.getContent());
        if (congViec.isGender()) {
            boy.setChecked(true);
            girl.setChecked(false);
        } else {
            boy.setChecked(false);
            girl.setChecked(true);
        }
        date.setText(congViec.getDate());
    }
}