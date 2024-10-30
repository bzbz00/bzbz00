package com.example.app_02;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new DiscussionFragment();
            case 2:
                return new MessagesFragment();
            case 3:
                return new ProfileFragment();
            default:
                return new HomeFragment(); // 默认显示 HomeFragment
        }
    }

    @Override
    public int getCount() {
        return 4; // 页面数量
    }
}
