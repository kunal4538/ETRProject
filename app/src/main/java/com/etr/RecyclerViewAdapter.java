package com.etr;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.etr.com.etr.model.Approve;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Approve> mApprove;
    AlertDialog.Builder acceptDialog;

    public RecyclerViewAdapter(Context mContext, List<Approve> mApprove) {
        this.mContext = mContext;
        this.mApprove = mApprove;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(mContext).inflate(R.layout.approve_card,parent,false);
        final MyViewHolder vHolder=new MyViewHolder(view);

        acceptDialog= new AlertDialog.Builder(mContext);
//        acceptDialog.setContentView(R.layout.dialogue_accept);

        vHolder.approveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("location","reached");
                android.support.v7.app.AlertDialog.Builder mBuilder=new android.support.v7.app.AlertDialog.Builder(mContext);
                final View mView=LayoutInflater.from(mContext).inflate(R.layout.dialogue_accept,null);
                mBuilder.setView(mView);
                final android.support.v7.app.AlertDialog dialog = mBuilder.create();
                TextView confirmText=(TextView) mView.findViewById(R.id.text_id);
                confirmText.setText("Are you sure you want to confirm "+mApprove.get(vHolder.getAdapterPosition()).getName()+"'s travel request");
                TextView confirmRequest=(TextView)mView.findViewById(R.id.yesBtn_id);
                final TextView cancel=(TextView)mView.findViewById(R.id.rejectBtn_id);
                confirmRequest.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                       Toast.makeText(mContext,"gotcha", Toast.LENGTH_LONG).show();
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(mContext,"canceled!", Toast.LENGTH_LONG).show();
                    }
                });



                dialog.show();

            }
        });

        vHolder.rejectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v7.app.AlertDialog.Builder mBuilder=new android.support.v7.app.AlertDialog.Builder(mContext);
                final View mView=LayoutInflater.from(mContext).inflate(R.layout.dialog_reject,null);
                mBuilder.setView(mView);
                final android.support.v7.app.AlertDialog dialog = mBuilder.create();
                TextView rejectText=(TextView) mView.findViewById(R.id.rejectText_id);
                rejectText.setText("Are you sure you want to Reject "+mApprove.get(vHolder.getAdapterPosition()).getName()+"'s travel request");
                TextView confirmReject=(TextView)mView.findViewById(R.id.confirmReject_id);
                final TextView cancel=(TextView)mView.findViewById(R.id.cancelReject_id);
                confirmReject.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(mContext,"gotcha rejected", Toast.LENGTH_LONG).show();
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(mContext,"canceled reject!", Toast.LENGTH_LONG).show();
                    }
                });



                dialog.show();



            }
        });


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

        private TextView approveBtn;
        private TextView rejectBtn;


        private LinearLayout approveCard;


        public MyViewHolder(View itemView) {
            super(itemView);

//            approveCard=(LinearLayout)itemView.findViewById(R.id.approveCard);

            rejectBtn=(TextView)itemView.findViewById(R.id.rejectBtn_id);

            approveBtn=(TextView)itemView.findViewById(R.id.acceptBtn_id);

            name=(TextView)itemView.findViewById(R.id.name_id);
            location=(TextView)itemView.findViewById(R.id.location_id);




        }
    }
}




















/*




package com.etr;

        import android.app.AlertDialog;
        import android.app.Dialog;
        import android.content.Context;
        import android.support.annotation.NonNull;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.etr.com.etr.model.Approve;

        import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Approve> mApprove;
    AlertDialog acceptDialog;

    public RecyclerViewAdapter(Context mContext, List<Approve> mApprove) {
        this.mContext = mContext;
        this.mApprove = mApprove;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(mContext).inflate(R.layout.approve_card,parent,false);
        final MyViewHolder vHolder=new MyViewHolder(view);

        acceptDialog=new Dialog(mContext);
        acceptDialog.setContentView(R.layout.dialogue_accept);

        vHolder.approveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView confirmText=(TextView) acceptDialog.findViewById(R.id.confirmDetails_id);
                confirmText.setText("are you sure you want to approve "+mApprove.get(vHolder.getAdapterPosition()).getName()+"'s travel request");

                TextView yesBtn=(TextView) acceptDialog.findViewById(R.id.acceptBtn_id);
                yesBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext,"got it", Toast.LENGTH_LONG).show();
                    }
                });
                acceptDialog.show();
            }
        });
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

        private TextView approveBtn;

        private LinearLayout approveCard;


        public MyViewHolder(View itemView) {
            super(itemView);

//            approveCard=(LinearLayout)itemView.findViewById(R.id.approveCard);


            approveBtn=(TextView)itemView.findViewById(R.id.acceptBtn_id);
            name=(TextView)itemView.findViewById(R.id.name_id);
            location=(TextView)itemView.findViewById(R.id.location_id);




        }
    }
}
*/

