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

public class PatMedRegistration extends AppCompatActivity {

    private String age,height,weight, pressure, sugar, bloodgroup;
    private String uid;
    EditText uAge, uHeight, uWeight, uPressure, uSugar,uBloodgroup;
    Button submit;
    DatabaseReference userDB;
    DatabaseReference userPatDB;

    @Override
    public void onBackPressed() {

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medregpat);

        userDB = FirebaseDatabase.getInstance().getReference("users");
        userPatDB = FirebaseDatabase.getInstance().getReference("users").child("Patients");

        uAge=findViewById(R.id.age);
        uHeight=findViewById(R.id.height);
        uWeight=findViewById(R.id.weight);
        uPressure=findViewById(R.id.pressure);
        uSugar=findViewById(R.id.sugar);
        uBloodgroup=findViewById(R.id.bloodgroup);
        submit=findViewById(R.id.submit_button);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            //email = user.getEmail();
            uid = user.getUid();
            //phone = user.getPhoneNumber();
        }


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age=uAge.getText().toString();
                height=uHeight.getText().toString();
                weight=uWeight.getText().toString();
                pressure=uPressure.getText().toString();
                sugar=uSugar.getText().toString();
                bloodgroup=uBloodgroup.getText().toString();
                //email = email.toString().trim();
                //phone = phone.toString().trim();

                //String userId = userDB.push().getKey();

                uid = uid.toString().trim();
                UserMedDetails userDetails = new UserMedDetails();
                userDetails.setuAge(age);
                userDetails.setuHeight(height);
                userDetails.setuWeight(weight);
                userDetails.setuPressure(pressure);
                userDetails.setuSugar(sugar);
                userDetails.setuBloodgroup(bloodgroup);
                userDetails.setuId(uid);
                userPatDB.child("PatientsMedDetails").child(uid).setValue(userDetails)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // Write was successful!
                                // ...
                                Toast.makeText(PatMedRegistration.this, "upload sucsess.",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Write failed
                                // ...
                                Toast.makeText(PatMedRegistration.this, "Profile info error",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                Intent intent=new Intent(PatMedRegistration.this, PatEmergency.class);
                startActivity(intent);
                finish();

            }
        });

    }

}