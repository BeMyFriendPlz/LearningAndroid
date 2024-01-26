package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Test_1_Activity extends AppCompatActivity {
    private EditText et1, et2;
    private Button bt;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_1);
        initView();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double h = Double.parseDouble(et1.getText().toString());
                    double w = Double.parseDouble(et2.getText().toString());
                    Double ans = w / (h * h);
                    tv.setText(String.valueOf(ans).substring(0,5));
                    Toast.makeText(Test_1_Activity.this, String.valueOf(ans).substring(0,5), Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(Test_1_Activity.this, "Vui Lòng Nhập 2 Số", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        bt = findViewById(R.id.bt);
        tv = findViewById(R.id.tv4);
    }
}