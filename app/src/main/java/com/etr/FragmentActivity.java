package com.etr;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.etr.com.etr.fragments.FragmentApprove;
import com.etr.com.etr.fragments.FragmentMyRequest;

public class FragmentActivity extends AppCompatActivity {
    Intent intent=getIntent();

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        tabLayout=(TabLayout)findViewById(R.id.tabLayoutId);
        viewPager=(ViewPager)findViewById(R.id.viewPaderId);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());

        //add Fragments here
        viewPagerAdapter.AddFragment(new FragmentApprove(),"Approve");
        viewPagerAdapter.AddFragment(new FragmentMyRequest(),"My Requests");


        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
