package com.etr;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

import com.etr.com.etr.fragments.FragmentApprove;
import com.etr.com.etr.fragments.FragmentMyRequest;

public class FragmentActivity extends AppCompatActivity {
    Intent intent=getIntent();

    ActionBar actionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        Spannable text = new SpannableString(actionBar.getTitle());
        text.setSpan(new ForegroundColorSpan(Color.BLACK), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        actionBar.setTitle(text);

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

