package com.epc.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MedicationActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    UserMedDetails medi;
    private Button btnMedi;

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(MedicationActivity.this, ShowPatientDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication);
        btnMedi = (Button) findViewById(R.id.btn_medi);
        final String userId = getIntent().getStringExtra("pat_id");
        getIncomingIntent();

       btnMedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MedicationActivity.this, ResasswordActivity.class));
                Intent intent = new Intent(MedicationActivity.this, UpdateMedicationActivity.class);
                intent.putExtra("pat_id", userId);
                startActivity(intent);
            }
        });
    }

    private void getIncomingIntent(){

        if(getIntent().hasExtra("pat_fname") && getIntent().hasExtra("pat_lname") && getIntent().hasExtra("pat_phone")&& getIntent().hasExtra("pat_email") && getIntent().hasExtra("pat_id")){

            String userfName = getIntent().getStringExtra("pat_fname");
            String userlName = getIntent().getStringExtra("pat_lname");
            String userPhone = getIntent().getStringExtra("pat_phone");
            String userEmail = getIntent().getStringExtra("pat_email");
            String userId = getIntent().getStringExtra("pat_id");

            setDetails(userfName, userlName, userPhone, userEmail, userId);
            fetchmed(userId);
        }
    }
    private void setDetails(String fName, String lName, String phone, String email, String userid){

       // String m_id = id;
        TextView first_name = findViewById(R.id.fName);
        first_name.setText(fName);

        TextView last_name = findViewById(R.id.lName);
        last_name.setText(lName);

        TextView phone_no = findViewById(R.id.mPhone);
        phone_no.setText(phone);

        TextView uemail = findViewById(R.id.mEmail);
        uemail.setText(email);

        //TextView m_age = findViewById(R.id.mAge);
        //m_age.setText(userid);
    }

    private void fetchmed(String uid){

        databaseReference = FirebaseDatabase.getInstance().getReference("users").child("Patients").child("PatientsMedDetails").child(uid);

        databaseReference.child("uAge").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String mage = snapshot.getValue(String.class);
                TextView m_age = findViewById(R.id.mAge);
                m_age.setText("Age: " + mage);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        databaseReference.child("uBloodgroup").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String mage = snapshot.getValue(String.class);
                TextView m_age = findViewById(R.id.mBg);
                m_age.setText("Blood Group: "+mage);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        databaseReference.child("uHeight").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String mage = snapshot.getValue(String.class);
                TextView m_age = findViewById(R.id.mHeight);
                m_age.setText("Height: "+mage);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        databaseReference.child("uPressure").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String mage = snapshot.getValue(String.class);
                TextView m_age = findViewById(R.id.mPressure);
                m_age.setText("Pressure: " + mage);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        databaseReference.child("uSugar").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String mage = snapshot.getValue(String.class);
                TextView m_age = findViewById(R.id.mSugar);
                m_age.setText("Sugar Level: " + mage);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        databaseReference.child("uWeight").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String mage = snapshot.getValue(String.class);
                TextView m_age = findViewById(R.id.mWeight);
                m_age.setText("Weight: "+mage);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
