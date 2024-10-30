package com.example.app_02;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化 ViewPager 和 BottomNavigationView
        viewPager = findViewById(R.id.view_pager);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        drawerLayout = findViewById(R.id.drawer_layout);

        // 初始化 ViewPager 适配器
        FragmentManager fragmentManager = getSupportFragmentManager();
        ViewPagerAdapter adapter = new ViewPagerAdapter(fragmentManager);
        viewPager.setAdapter(adapter);


        // BottomNavigationView 与 ViewPager 联动
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                viewPager.setCurrentItem(0);
                return true;
            } else if (item.getItemId() == R.id.nav_discussion) {
                viewPager.setCurrentItem(1);
                return true;
            } else if (item.getItemId() == R.id.nav_messages) {
                viewPager.setCurrentItem(2);
                return true;
            } else if (item.getItemId() == R.id.nav_profile) {
                viewPager.setCurrentItem(3);
                return true;
            } else {
                return false;
            }
        });

        // ViewPager 页面切换监听器，用于更新 BottomNavigationView 的选中项
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                // 更新 BottomNavigationView 中对应项的选中状态
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
