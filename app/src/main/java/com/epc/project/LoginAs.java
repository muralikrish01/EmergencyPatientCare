package com.epc.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginAs extends AppCompatActivity {
    private Button Patient, Doctor;

    @Override
    public void onBackPressed() {

    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginas);

        Patient = (Button) findViewById(R.id.patient);
        Doctor = (Button) findViewById(R.id.doctor);

        Patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user = new Intent(LoginAs.this, LoginActivity.class);
                startActivity(user);
            }
        });

        Doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user = new Intent(LoginAs.this, DoctorLoginActivity.class);
                startActivity(user);
            }
        });


    }
}

