package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Excer_8_1_Activity extends AppCompatActivity {
    private EditText et1, et2;
    private TextView tv;
    private Button bt;
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.excer_8_1);
        initView();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double a = Double.parseDouble(et1.getText().toString());
                    Double b = Double.parseDouble(et2.getText().toString());
                    tv.setText(TinhToan(a, b, "+"));
                    Toast.makeText(getApplicationContext(), TinhToan(a, b, "+"), Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Nhap 2 so", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    Double a = Double.parseDouble(et1.getText().toString());
                    Double b = Double.parseDouble(et2.getText().toString());
                    String p = sp.getSelectedItem().toString();
                    tv.setText(TinhToan(a, b, p));
                    Toast.makeText(getApplicationContext(), TinhToan(a, b, p), Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Nhap 2 so", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initView() {
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv = findViewById(R.id.tv4);
        bt = findViewById(R.id.bt);
        sp = findViewById(R.id.sp);
    }

    private String TinhToan(Double a, Double b, String p) {
        String s = "";
        switch (p) {
            case "+":
                s = "Tong: " + (a + b);
                break;
            case "-":
                s = "Hieu: " + (a - b);
                break;
            case "*":
                s = "Tich: " + (a * b);
                break;
            case ":":
                if (b == 0)
                    s = "Khong chia duoc cho 0";
                else
                    s = "Thuong: " + (a / b);
                break;
        }
        return s;
    }
}