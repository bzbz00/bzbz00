package com.example.app_02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private DrawerLayout drawerLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // 确保活动不为 null
        if (getActivity() != null) {
            // 获取 DrawerLayout 的引用
            drawerLayout = getActivity().findViewById(R.id.drawer_layout);

            // 设置 Toolbar 和侧边栏按钮
            Toolbar toolbar = view.findViewById(R.id.toolbar);
            ImageButton btnMenu = view.findViewById(R.id.btn_menu);

            // 设置 Toolbar
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
            // 点击侧边栏按钮打开或关闭侧边栏
            btnMenu.setOnClickListener(v -> {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            });
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // 如果不再使用 DrawerLayout，可以将其设置为 null，防止内存泄漏
        drawerLayout = null;
    }
}
