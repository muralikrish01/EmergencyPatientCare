package com.epc.project;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<DoctorDetails> MainImageUploadInfoList;

    public RecyclerViewAdapter(Context context, List<DoctorDetails> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        DoctorDetails doctor_Details = MainImageUploadInfoList.get(position);

        holder.DoctorNameTextView.setText("Name: " + doctor_Details.getdFirstName());

        holder.DoctorPhnTextView.setText("Phone: " + doctor_Details.getdPhone());

        holder.DoctorHosTextView.setText("Hospital: " + doctor_Details.getdHospital());

        holder.DoctorSplTextView.setText("Specialization: " + doctor_Details.getdSpecial());

    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView DoctorNameTextView;
        public TextView DoctorPhnTextView;
        public TextView DoctorHosTextView;
        public TextView DoctorSplTextView;

        public ViewHolder(View itemView) {

            super(itemView);

            DoctorNameTextView = (TextView) itemView.findViewById(R.id.ShowDoctorNameTextView);

            DoctorPhnTextView = (TextView) itemView.findViewById(R.id.ShowDoctorPhoneTextView);

            DoctorHosTextView = (TextView) itemView.findViewById(R.id.ShowDoctorHospitalTextView);

            DoctorSplTextView = (TextView) itemView.findViewById(R.id.ShowDoctorSpecialTextView);
        }
    }
}