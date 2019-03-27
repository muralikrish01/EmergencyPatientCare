package com.epc.project;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowDoctorDetailsActivity extends AppCompatActivity {

    private String did;

    DatabaseReference databaseReference;

    ProgressDialog progressDialog;

    List<DoctorDetails> list = new ArrayList<>();

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter ;

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(ShowDoctorDetailsActivity.this, PatEmergency.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_doctor_details);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(ShowDoctorDetailsActivity.this));

        progressDialog = new ProgressDialog(ShowDoctorDetailsActivity.this);

        progressDialog.setMessage("Loading Data from Firebase Database");

        progressDialog.show();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            did = user.getUid();
        }
        Log.d("hi","murali");
        databaseReference = FirebaseDatabase.getInstance().getReference("users").child("Doctors");



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                list.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    DoctorDetails doctor_Details = dataSnapshot.getValue(DoctorDetails.class);


                    list.add(doctor_Details);
                }

                Log.d("list", list.toString());

                adapter = new RecyclerViewAdapter(ShowDoctorDetailsActivity.this, list);

                recyclerView.setAdapter(adapter);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();

            }
        });

    }
}
