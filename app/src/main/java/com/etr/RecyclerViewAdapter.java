package com.etr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.etr.com.etr.model.Approve;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Approve> mApprove;

    public RecyclerViewAdapter(Context mContext, List<Approve> mApprove) {
        this.mContext = mContext;
        this.mApprove = mApprove;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(mContext).inflate(R.layout.approve_card,parent,false);
        MyViewHolder vHolder=new MyViewHolder(view);


        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(mApprove.get(position).getName());
        holder.location.setText(mApprove.get(position).getLocation());


    }

    @Override
    public int getItemCount() {
        return mApprove.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{



        private TextView name;
        private TextView location;

        public MyViewHolder(View itemView) {
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.nameTextView);
            location=(TextView)itemView.findViewById(R.id.locationTextView);




        }
    }
}
