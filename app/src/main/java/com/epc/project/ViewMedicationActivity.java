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

public class ViewMedicationActivity extends AppCompatActivity {

    private String uid;

    DatabaseReference databaseReference;

    ProgressDialog progressDialog;

    List<MedicationDetails> listm = new ArrayList<>();

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter ;

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(ViewMedicationActivity.this, PatEmergency.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_medication);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_med);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(ViewMedicationActivity.this));

        progressDialog = new ProgressDialog(ViewMedicationActivity.this);

        progressDialog.setMessage("Loading Data from Firebase Database");

        progressDialog.show();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            uid = user.getUid();
        }

        databaseReference = FirebaseDatabase.getInstance().getReference("users").child("Patients").child("PatientsMedicationDetails").child(uid);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                listm.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    for (DataSnapshot snapshot1 : dataSnapshot.getChildren()) {

                        MedicationDetails user_Details = snapshot1.getValue(MedicationDetails.class);

                        listm.add(user_Details);
                    }
                }

                adapter = new RecyclerViewAdapterMed(ViewMedicationActivity.this, listm);

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
