package com.etr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.etr.com.etr.model.MyRequestModel;

import java.util.List;

public class MyRequestRecyclerViewAdapter extends RecyclerView.Adapter<MyRequestRecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<MyRequestModel> myRequestModelList;

    public MyRequestRecyclerViewAdapter(Context mContext, List<MyRequestModel> myRequestModelList) {
        this.mContext = mContext;
        this.myRequestModelList = myRequestModelList;
    }



    @NonNull
    @Override
    public MyRequestRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(mContext).inflate(R.layout.my_request_card2,parent,false);
        MyViewHolder vHolder=new MyViewHolder(view);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRequestRecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.name.setText(myRequestModelList.get(position).getName());
        holder.location.setText(myRequestModelList.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return myRequestModelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{



        private TextView name;
        private TextView location;


        public MyViewHolder(View itemView) {
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.name_id);
            location=(TextView)itemView.findViewById(R.id.location_id);




        }
    }

}
