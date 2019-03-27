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

public class DoctorRegistration extends AppCompatActivity {

    private String firstname,lastname,city,hospital,special,email,phone;
    private String did;
    EditText dFirstName, dLastName, dCity, dHospital, dSpecial;
    Button submit;
    DatabaseReference userDB;
    DatabaseReference userDocDB;

    @Override
    public void onBackPressed() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorreg);

        userDB = FirebaseDatabase.getInstance().getReference("users");
        userDocDB = FirebaseDatabase.getInstance().getReference("users").child("Doctors");
        dFirstName=findViewById(R.id.dfirst_name);
        dLastName=findViewById(R.id.dlast_name);
        dCity=findViewById(R.id.dcity);
        dHospital=findViewById(R.id.dhospital);
        dSpecial=findViewById(R.id.dspecial);
        submit=findViewById(R.id.submit_button);

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            email = user.getEmail();
            did = user.getUid();
            phone = user.getPhoneNumber();
        }


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstname=dFirstName.getText().toString();
                lastname=dLastName.getText().toString();
                city=dCity.getText().toString();
                hospital=dHospital.getText().toString();
                special=dSpecial.getText().toString();
                email = email.toString().trim();
                phone = phone.toString().trim();

                //String userId = userDB.push().getKey();
                //DoctorDetails userDetails = new DoctorDetails(firstname, lastname, city, hospital, special, email, phone);
                DoctorDetails userDetails = new DoctorDetails();
                userDetails.setdCity(city);
                userDetails.setdFirstName(firstname);
                userDetails.setdLastName(lastname);
                userDetails.setdHospital(hospital);
                userDetails.setdSpecial(special);
                userDetails.setdEmail(email);
                userDetails.setdPhone(phone);

                userDocDB.child(did).setValue(userDetails)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // Write was successful!
                                // ...
                                Toast.makeText(DoctorRegistration.this, "upload sucsess.",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Write failed
                                // ...
                                Toast.makeText(DoctorRegistration.this, "Profile info error",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                Intent intent=new Intent(DoctorRegistration.this, DocEmergency.class);
                startActivity(intent);
                finish();

            }
        });

    }

}