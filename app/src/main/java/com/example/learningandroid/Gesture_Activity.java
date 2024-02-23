package com.example.learningandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Gesture_Activity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener, View.OnTouchListener {
    private ImageView iv;
    private TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;
    private GestureDetector detector;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gesture);
        initView();
        iv.setOnTouchListener(this);
        detector = new GestureDetector(this, this);
        detector.setOnDoubleTapListener(this);
    }

    private void initView() {
        iv = findViewById(R.id.iv);
        t1 = findViewById(R.id.txt1);
        t2 = findViewById(R.id.txt2);
        t3 = findViewById(R.id.txt3);
        t4 = findViewById(R.id.txt4);
        t5 = findViewById(R.id.txt5);
        t6 = findViewById(R.id.txt6);
        t7 = findViewById(R.id.txt7);
        t8 = findViewById(R.id.txt8);
        t9 = findViewById(R.id.txt9);
        t10 = findViewById(R.id.txt10);
        t11 = findViewById(R.id.txt11);
        t12 = findViewById(R.id.txt12);
    }

    @Override
    public boolean onDown(@NonNull MotionEvent e) {
        t1.setText("Down Touch");
        t2.setText("x:" + e.getX() + " y:" + e.getY());
        return true;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent e) {
        t3.setText("Show Press");
        t4.setText("x:" + e.getX() + " y:" + e.getY());
    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent e) {
        t5.setText("Single Tap Up");
        t6.setText("x:" + e.getX() + " y:" + e.getY());
        return true;
    }

    @Override
    public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
        t7.setText("Scroll");
        t8.setText("x:" + e1.getX() + " y:" + e1.getY());
        return true;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent e) {

    }

    @Override
    public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
        t9.setText("Fling");
        t10.setText("x:" + e1.getX() + " y:" + e1.getY());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(@NonNull MotionEvent e) {
        t11.setText("Double Tap");
        t12.setText("x:" + e.getX() + " y:" + e.getY());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        detector.onTouchEvent(event);
        return true;
    }
}