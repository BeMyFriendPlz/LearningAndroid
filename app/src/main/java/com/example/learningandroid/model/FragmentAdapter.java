package com.example.learningandroid.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {
    private int pageNumber;

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.pageNumber = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Fragment_Food();
            case 1:
                return new Fragment_Movie();
            case 2:
                return new Fragment_Travel();
        }
        return null;
    }

    @Override
    public int getCount() {
        return pageNumber;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        // Dùng để thổi dữ liệu vào tab
        switch (position) {
            case 0:
                return "FOOD";
            case 1:
                return "MOVIE";
            case 2:
                return "TRAVEL";
        }
        return null;
    }
}
