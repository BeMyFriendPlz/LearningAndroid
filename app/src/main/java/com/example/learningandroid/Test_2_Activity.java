package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Test_2_Activity extends AppCompatActivity {
    private EditText et;
    private Button bt;
    private RadioButton rb1, rb2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_2);
        initView();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double r = Double.parseDouble(et.getText().toString());
                    double ans = 0;
                    if (rb1.isChecked()) {
                        ans = 4 * Math.PI * r * r;
                    }
                    if (rb2.isChecked()) {
                        ans = (4 * Math.PI * r * r * r) / 3;
                    }
                    tv.setText(String.valueOf(ans).substring(0,10));
                } catch (NumberFormatException e) {
                    Toast.makeText(Test_2_Activity.this, "Nhập 1 số", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        et = findViewById(R.id.et);
        bt = findViewById(R.id.bt);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        tv = findViewById(R.id.tv3);
    }
}