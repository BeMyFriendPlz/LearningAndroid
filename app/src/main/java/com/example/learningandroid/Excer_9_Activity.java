package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class Excer_9_Activity extends AppCompatActivity implements View.OnClickListener{
    private Button b1, b2;
    private EditText et1, et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.excer_9);
        initView();
        et1.setOnClickListener(this);
        et2.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    private void initView() {
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
    }

    @Override
    public void onClick(View v) {
        Calendar c = Calendar.getInstance();
        if (v == et1 || v == b1) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    et1.setText(hourOfDay + ":" + minute);
                }
            }, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), false);
            timePickerDialog.show();
        }

        if (v == et2 || v == b2) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    et2.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                }
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        }
    }
}