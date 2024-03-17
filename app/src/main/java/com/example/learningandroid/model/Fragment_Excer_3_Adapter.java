package com.example.learningandroid.model;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Fragment_Excer_3_Adapter extends FragmentStatePagerAdapter {
    private int pageNumber = 2;

    public Fragment_Excer_3_Adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Fragment_Home();
            case 1:
                return new Fragment_Search();
        }
        return null;
    }

    @Override
    public int getCount() {
        return pageNumber;
    }

}
