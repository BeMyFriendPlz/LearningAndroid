package com.example.learningandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.learningandroid.model.FragmentAdapter;
import com.example.learningandroid.model.HorizontalFlipTransformation;
import com.google.android.material.tabs.TabLayout;

public class Demo_View_Pager_Activity extends AppCompatActivity implements View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Button back, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_view_pager);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        back = findViewById(R.id.back);
        next = findViewById(R.id.next);
        back.setOnClickListener(this);
        next.setOnClickListener(this);
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), 3);
        viewPager.setPageTransformer(true, new HorizontalFlipTransformation());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        // Khởi tạo fragment đầu tiên
        tabLayout.setTabTextColors(Color.BLACK, Color.GREEN);
        back.setBackgroundColor(Color.GREEN);
        next.setBackgroundColor(Color.GREEN);

        // Xử lý sự kiện của tab khi chuyển đổi fragment
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tabLayout.setTabTextColors(Color.BLACK, Color.GREEN);
                        back.setBackgroundColor(Color.GREEN);
                        next.setBackgroundColor(Color.GREEN);
                        break;
                    case 1:
                        tabLayout.setTabTextColors(Color.BLACK, Color.RED);
                        back.setBackgroundColor(Color.RED);
                        next.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        tabLayout.setTabTextColors(Color.BLACK, Color.BLUE);
                        back.setBackgroundColor(Color.BLUE);
                        next.setBackgroundColor(Color.BLUE);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    // Xử lý sự kiện khi dùng nút để chuyển đổi fragment
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next:
                if (viewPager.getCurrentItem() == 2) {
                    return;
                } else {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
                break;
            case R.id.back:
                if (viewPager.getCurrentItem() == 0) {
                    return;
                } else {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() > 0) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else {
            super.onBackPressed();
        }
    }
}