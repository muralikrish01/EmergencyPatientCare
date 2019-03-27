package com.epc.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateMedicationActivity extends AppCompatActivity {

    private String docName,date,med1,med2,med3,med4,med5;
    private String userId,mdid,memail,mphone;
    EditText mName, mDate, m1, m2,m3,m4,m5;
    Button mSubmit;
    DatabaseReference userDB;
    DatabaseReference userPatDB;

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(UpdateMedicationActivity.this, MedicationActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_medication);

        userId = getIntent().getStringExtra("pat_id");
        userDB = FirebaseDatabase.getInstance().getReference("users");
        userPatDB = FirebaseDatabase.getInstance().getReference("users").child("Patients");
        mName=findViewById(R.id.mname);
        mDate=findViewById(R.id.mdate);
        m1=findViewById(R.id.med1);
        m2=findViewById(R.id.med2);
        m3=findViewById(R.id.med3);
        m4=findViewById(R.id.med4);
        m5=findViewById(R.id.med5);
        mSubmit=findViewById(R.id.msubmit_button);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            memail = user.getEmail();
            mdid = user.getUid();
            mphone = user.getPhoneNumber();
        }


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                docName=mName.getText().toString();
                date=mDate.getText().toString();
                med1=m1.getText().toString();
                med2=m2.getText().toString();
                med3=m3.getText().toString();
                med4=m4.getText().toString();
                med5=m5.getText().toString();
                userId = userId.toString().trim();
                memail = memail.toString().trim();
                mphone = mphone.toString().trim();
                mdid = mdid.toString().trim();

                //String userId = userDB.push().getKey();
                // UserId uuid = new UserId(uid);
                //userPatDB.setValue(uuid);
                MedicationDetails muserDetails = new MedicationDetails();
                muserDetails.setmDocName(docName);
                muserDetails.setmDate(date);
                muserDetails.setmMed1(med1);
                muserDetails.setmMed2(med2);
                muserDetails.setmMed3(med3);
                muserDetails.setmMed4(med4);
                muserDetails.setmMed5(med5);
                muserDetails.setmId(userId);
                muserDetails.setmdId(mdid);
                muserDetails.setmEmail(memail);
                muserDetails.setmPhone(mphone);
                userPatDB.child("PatientsMedicationDetails").child(userId).child(mdid).child(date).setValue(muserDetails)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // Write was successful!
                                // ...
                                Toast.makeText(UpdateMedicationActivity.this, "upload sucsess.",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Write failed
                                // ...
                                Toast.makeText(UpdateMedicationActivity.this, "Profile info error",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });


            }
        });

    }
}