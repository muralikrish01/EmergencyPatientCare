package com.epc.project;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapterPat extends RecyclerView.Adapter<RecyclerViewAdapterPat.ViewHolder> {

    Context context;
    List<UserDetails> MainImageUploadInfoList1;

    public RecyclerViewAdapterPat(Context context, List<UserDetails> TempList) {

        this.MainImageUploadInfoList1 = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items_pat, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final UserDetails user_Details = MainImageUploadInfoList1.get(position);

        holder.UserNameTextView.setText(user_Details.getuFirstName());

        holder.UserPhnTextView.setText(user_Details.getuPhone());

        holder.parentLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, MedicationActivity.class);
                intent.putExtra("pat_fname", user_Details.getuFirstName());
                intent.putExtra("pat_lname", user_Details.getuLastName());
                intent.putExtra("pat_phone", user_Details.getuPhone());
                intent.putExtra("pat_email", user_Details.getuEmail());
                intent.putExtra("pat_id", user_Details.getuId());
                context.startActivity(intent);
            }
        } );

    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList1.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout parentLayout;

        public TextView UserNameTextView;
        public TextView UserPhnTextView;

        public ViewHolder(View itemView) {

            super(itemView);

            UserNameTextView = (TextView) itemView.findViewById(R.id.ShowUserNameTextView);

            UserPhnTextView = (TextView) itemView.findViewById(R.id.ShowUserPhoneTextView);

            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}