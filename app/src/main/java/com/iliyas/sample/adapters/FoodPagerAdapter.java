package com.iliyas.sample.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.iliyas.sample.fragments.FoodListFragment;

public class FoodPagerAdapter extends FragmentStateAdapter {
    public FoodPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return FoodListFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
