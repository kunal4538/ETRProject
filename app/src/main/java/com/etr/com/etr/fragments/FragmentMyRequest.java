package com.etr.com.etr.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etr.MyRequestRecyclerViewAdapter;
import com.etr.R;
import com.etr.com.etr.model.MyRequestModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentMyRequest extends Fragment {
    View view;
    private RecyclerView myRecyclerView;
    private List<MyRequestModel> myRequestList;
    public FragmentMyRequest() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.my_request_fragment,container,false);
        myRecyclerView =(RecyclerView)view.findViewById(R.id.myRequest_RecyclerView);
        MyRequestRecyclerViewAdapter myRequestRecyclerViewAdapter=new MyRequestRecyclerViewAdapter(getContext(),myRequestList);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(myRequestRecyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myRequestList = new ArrayList<>();
        myRequestList.add(new MyRequestModel("Nishant kakkar", "usa"));
        myRequestList.add(new MyRequestModel("kunal", "London"));
        myRequestList.add(new MyRequestModel("divya", "Asia"));

    }
}
