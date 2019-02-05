package com.etr;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter  extends FragmentPagerAdapter {

    private final List<Fragment> firstFragment=new ArrayList<>();
    private final List<String> firstTitles=new ArrayList<String>();


    public ViewPagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return firstFragment.get(position);
    }

    @Override
    public int getCount() {
        return firstTitles.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return firstTitles.get(position);
    }

    public void AddFragment(Fragment fragment, String title){
        firstFragment.add(fragment);
        firstTitles.add(title);
    }
}
