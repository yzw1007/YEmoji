package com.fyfeng.yemoji;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import io.github.rockerhieu.emojicon.emoji.Emojicon;

public class ExpPagerAdapter extends FragmentPagerAdapter {
    private final int[] types = new int[]{Emojicon.TYPE_PEOPLE, Emojicon.TYPE_NATURE, Emojicon.TYPE_OBJECTS, Emojicon.TYPE_PLACES, Emojicon.TYPE_SYMBOLS};

    public ExpPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ExpFragment.newInstance(types[position], null);
    }

    @Override
    public int getCount() {
        return types.length;
    }
}
