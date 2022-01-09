package com.example.lichsudonhang;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.lichsudonhang.fragment.DaGiaoFragment;
import com.example.lichsudonhang.fragment.DangGiao_Fragment;
import com.example.lichsudonhang.fragment.DaGiao_Fragment;
import com.example.lichsudonhang.fragment.DaHuy_Fragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new DaGiaoFragment();
            case 2:
                return new DaHuy_Fragment();
            case 0:
            default:
                return new DangGiao_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
