package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

public class Exer_8_2_Activity extends AppCompatActivity {
    private CheckBox cb1, cb2, cb3;
    private RadioButton rb1, rb2;
    private RatingBar rb;
    private Spinner s1, s2;
    private Button b;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.excer_8_2);
        initView();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "Your phone: ";
                if (cb1.isChecked()) {
                    s += cb1.getText().toString() + ",";
                }
                if (cb2.isChecked()) {
                    s += cb2.getText().toString() + ",";
                }
                if (cb3.isChecked()) {
                    s += cb3.getText().toString() + ",";
                }
                if (s.endsWith(",")) {
                    s = s.substring(0,s.length() - 1) + "\n";
                } else {
                    s += "\n";
                }
                s += "Your gender: ";
                if (rb1.isChecked()) {
                    s += rb1.getText().toString() + "\n";
                }
                if (rb2.isChecked()) {
                    s += rb2.getText().toString() +"\n";
                }
                s += "Your romance: " + rb.getRating() + "\n";
                s += "Your country: " + s1.getSelectedItem().toString() + "\n";
                s += "Your university: " + s2.getSelectedItem().toString();
                tv.setText(s);
            }
        });
    }

    private void initView() {
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb = findViewById(R.id.rb);
        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        b = findViewById(R.id.b);
        tv = findViewById(R.id.tv4);
    }
}