package com.example.learningandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Excer_11_Activity extends AppCompatActivity {
    private TextView tv1, tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.excer_11);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        registerForContextMenu(tv1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.iFile:
                Toast.makeText(this, "Selected File", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iExit:
                System.exit(0);
                break;
            case R.id.iEmail:
                Toast.makeText(this, "Selected Email", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iPhone:
                Toast.makeText(this, "Selected Phone", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.mycontextmenu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.it1:
                tv2.setTextColor(getColor(android.R.color.holo_red_dark));
                break;
            case R.id.it2:
                tv2.setTextColor(getColor(android.R.color.holo_green_dark));
                break;
            case R.id.it3:
                tv2.setTextColor(getColor(android.R.color.holo_blue_dark));
                break;
        }
        return super.onContextItemSelected(item);
    }
}