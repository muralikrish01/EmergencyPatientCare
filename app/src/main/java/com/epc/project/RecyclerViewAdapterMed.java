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

public class RecyclerViewAdapterMed extends RecyclerView.Adapter<RecyclerViewAdapterMed.ViewHolder> {

    Context context;
    List<MedicationDetails> MainImageUploadInfoListm;

    public RecyclerViewAdapterMed(Context context, List<MedicationDetails> TempList) {

        this.MainImageUploadInfoListm = TempList;

        this.context = context;
    }

    @Override
    public RecyclerViewAdapterMed.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items_med, parent, false);

        RecyclerViewAdapterMed.ViewHolder viewHolder = new RecyclerViewAdapterMed.ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerViewAdapterMed.ViewHolder holder, int position) {

        final MedicationDetails user_Details = MainImageUploadInfoListm.get(position);

        holder.MedNameTextView.setText(user_Details.getmDocName());

        holder.MedPhnTextView.setText(user_Details.getmPhone());

        holder.MedDateTextView.setText(user_Details.getmDate());

        holder.parentLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, MedicationViewActivity.class);
                intent.putExtra("med_name", user_Details.getmDocName());
                intent.putExtra("med_phone", user_Details.getmPhone());
                intent.putExtra("med_email", user_Details.getmEmail());
                intent.putExtra("med_date", user_Details.getmDate());
                intent.putExtra("med_1", user_Details.getmMed1());
                intent.putExtra("med_2", user_Details.getmMed2());
                intent.putExtra("med_3", user_Details.getmMed3());
                intent.putExtra("med_4", user_Details.getmMed4());
                intent.putExtra("med_5", user_Details.getmMed5());
                context.startActivity(intent);
            }
        } );

    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoListm.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout parentLayout;

        public TextView MedNameTextView;
        public TextView MedPhnTextView;
        public TextView MedDateTextView;

        public ViewHolder(View itemView) {

            super(itemView);

            MedNameTextView = (TextView) itemView.findViewById(R.id.ShowMedNameTextView);

            MedPhnTextView = (TextView) itemView.findViewById(R.id.ShowMedPhoneTextView);

            MedDateTextView = (TextView) itemView.findViewById(R.id.ShowMedDateTextView);

            parentLayout = itemView.findViewById(R.id.parent_layout_m);
        }
    }
}
