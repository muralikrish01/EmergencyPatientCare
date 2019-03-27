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

public class Registration extends AppCompatActivity {

    private String firstname,lastname,city,ec1,ec2,email,phone;
    private String uid;
    EditText uFirstName, uLastName, uCity, uEc1,uEc2;
    Button submit;
    DatabaseReference userDB;
    DatabaseReference userPatDB;

    @Override
    public void onBackPressed() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        userDB = FirebaseDatabase.getInstance().getReference("users");
        userPatDB = FirebaseDatabase.getInstance().getReference("users").child("Patients");
        uFirstName=findViewById(R.id.first_name);
        uLastName=findViewById(R.id.last_name);
        uCity=findViewById(R.id.city);
        uEc1=findViewById(R.id.ec1);
        uEc2=findViewById(R.id.ec2);
        submit=findViewById(R.id.submit_button);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            email = user.getEmail();
            uid = user.getUid();
            phone = user.getPhoneNumber();
        }


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstname=uFirstName.getText().toString();
                lastname=uLastName.getText().toString();
                city=uCity.getText().toString();
                ec1=uEc1.getText().toString();
                ec2=uEc2.getText().toString();
                uid = uid.toString().trim();
                email = email.toString().trim();
                phone = phone.toString().trim();

                //String userId = userDB.push().getKey();
               // UserId uuid = new UserId(uid);
                //userPatDB.setValue(uuid);
                UserDetails userDetails = new UserDetails();
                userDetails.setuFirstName(firstname);
                userDetails.setuLastName(lastname);
                userDetails.setuCity(city);
                userDetails.setuEc1(ec1);
                userDetails.setuEc2(ec2);
                userDetails.setuEmail(email);
                userDetails.setuPhone(phone);
                userDetails.setuId(uid);
                userPatDB.child("PatientsRegDetails").child(uid).setValue(userDetails)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // Write was successful!
                                // ...
                                Toast.makeText(Registration.this, "upload sucsess.",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Write failed
                                // ...
                                Toast.makeText(Registration.this, "Profile info error",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                Intent intent=new Intent(Registration.this, PatMedRegistration.class);
                startActivity(intent);
                finish();

            }
        });

    }

}