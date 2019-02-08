package com.etr.com.etr.fragments;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etr.R;
import com.etr.RecyclerViewAdapter;
import com.etr.com.etr.model.Approve;

import java.util.ArrayList;
import java.util.List;

public class FragmentApprove extends Fragment {
    View view;
    private RecyclerView myRecyclerView;
    private List<Approve> approveList;
    public FragmentApprove(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.approve_fragment,container,false);
        myRecyclerView =(RecyclerView)view.findViewById(R.id.approve_RecyclerView);
        RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(getContext(),approveList);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        approveList=new ArrayList<>();
        approveList.add(new Approve("kunal Aggarwal","London"));
        approveList.add(new Approve("nishant kakkar","London"));
        approveList.add(new Approve("divya","Europe"));



    }
}
