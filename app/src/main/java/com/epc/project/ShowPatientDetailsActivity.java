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

public class ShowPatientDetailsActivity extends AppCompatActivity {

    private String uid;

    DatabaseReference databaseReference;

    ProgressDialog progressDialog;

    List<UserDetails> list1 = new ArrayList<>();

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter ;

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(ShowPatientDetailsActivity.this, DocEmergency.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_patient_details);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_pat);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(ShowPatientDetailsActivity.this));

        progressDialog = new ProgressDialog(ShowPatientDetailsActivity.this);

        progressDialog.setMessage("Loading Data from Firebase Database");

        progressDialog.show();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference("users").child("Patients").child("PatientsRegDetails");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                list1.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    UserDetails user_Details = dataSnapshot.getValue(UserDetails.class);


                    list1.add(user_Details);
                }

                adapter = new RecyclerViewAdapterPat(ShowPatientDetailsActivity.this, list1);

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
