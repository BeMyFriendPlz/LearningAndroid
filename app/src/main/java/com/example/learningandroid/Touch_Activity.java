package com.example.learningandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Touch_Activity extends AppCompatActivity {
    private EditText et1, et2, et3, et4;
    private ImageView iv;
    private float x_down, y_down;

    @Override
    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touch);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        iv = findViewById(R.id.iv);

        iv.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        x_down = event.getX();
                        y_down = event.getY();
                        et1.setText(x_down + "");
                        et2.setText(y_down + "");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        et3.setText((float) event.getX() + "");
                        et4.setText((float) event.getY() + "");
                        float dx = event.getX() - x_down;
                        float dy = event.getY() - y_down;
                        iv.setX(iv.getX() + dx);
                        iv.setY(iv.getY() + dy);
                        break;
                }
                return true;
            }
        });
    }
}