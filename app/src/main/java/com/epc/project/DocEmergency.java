package com.epc.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
public class DocEmergency extends AppCompatActivity {
    private Button uSos, uMedibot, uSettings, uDocview, uUpdate;

    @Override
    public void onBackPressed() {

    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docemergency);

        uSos = (Button) findViewById(R.id.sos_doc);
        uMedibot = (Button) findViewById(R.id.medibot_doc);
        uDocview = (Button) findViewById(R.id.patview);
        uSettings = (Button) findViewById(R.id.docsetting);
        uUpdate = (Button) findViewById(R.id.docdet);

        uSos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user = new Intent(DocEmergency.this, SOSActivity.class);
                startActivity(user);
            }
        });

        uUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user = new Intent(DocEmergency.this, DoctorRegistration.class);
                startActivity(user);
            }
        });

        uDocview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user = new Intent(DocEmergency.this, ShowPatientDetailsActivity.class);
                startActivity(user);
            }
        });

        uMedibot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user = new Intent(DocEmergency.this, ChatBotActivity.class);
                startActivity(user);
            }
        });

        uSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user = new Intent(DocEmergency.this, MainActivity.class);
                startActivity(user);
            }
        });

    }
}
