package com.epc.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class PatEmergency extends AppCompatActivity {
    private Button uSos, uMedibot, uSettings, uDocview, uMedication, uRegMedi;

    @Override
    public void onBackPressed() {

    }
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patemergency);

        uSos = (Button) findViewById(R.id.sos);
        uMedibot = (Button) findViewById(R.id.medibot);
        uDocview = (Button) findViewById(R.id.docview);
        uMedication = (Button) findViewById(R.id.medication);
        uSettings = (Button) findViewById(R.id.patsetting);
        uRegMedi = (Button) findViewById(R.id.updatemedi);

        uSos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user = new Intent(PatEmergency.this, SOSActivity.class);
                startActivity(user);
            }
        });

        uDocview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user = new Intent(PatEmergency.this, ShowDoctorDetailsActivity.class);
                startActivity(user);
            }
        });

        uMedibot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user = new Intent(PatEmergency.this, ChatBotActivity.class);
                startActivity(user);
            }
        });
        uMedication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user = new Intent(PatEmergency.this, ViewMedicationActivity.class);
                startActivity(user);
            }
        });

        uSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user = new Intent(PatEmergency.this, MainActivity.class);
                startActivity(user);
            }
        });

        uRegMedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user = new Intent(PatEmergency.this, PatMedRegistration.class);
                startActivity(user);
            }
        });

    }
}
