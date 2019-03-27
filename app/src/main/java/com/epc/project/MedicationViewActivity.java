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

public class MedicationViewActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    MedicationDetails medi;

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(MedicationViewActivity.this, ViewMedicationActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication_view);
        getIncomingIntent();
    }

    private void getIncomingIntent(){

            String medName = getIntent().getStringExtra("med_name");
            String medPhn = getIntent().getStringExtra("med_phone");
            String medEmail = getIntent().getStringExtra("med_email");
            String medDate = getIntent().getStringExtra("med_date");
            String med1 = getIntent().getStringExtra("med_1");
            String med2 = getIntent().getStringExtra("med_2");
            String med3 = getIntent().getStringExtra("med_3");
            String med4 = getIntent().getStringExtra("med_4");
            String med5 = getIntent().getStringExtra("med_5");

            setDetails(medName, medPhn, medEmail, medDate, med1, med2, med3, med4, med5);
        //    fetchmed(userId);

    }
    private void setDetails(String medName, String medPhn, String medEmail, String medDate, String med1, String med2, String med3, String med4, String med5){

        // String m_id = id;
        TextView first_name = findViewById(R.id.mpName);
        first_name.setText(medName);

        TextView last_name = findViewById(R.id.mpPhn);
        last_name.setText(medPhn);

        TextView phone_no = findViewById(R.id.mpEmail);
        phone_no.setText(medEmail);

        TextView uemail = findViewById(R.id.mpDate);
        uemail.setText(medDate);

        TextView u1email = findViewById(R.id.m1);
        u1email.setText(med1);
        TextView u2email = findViewById(R.id.m2);
        u2email.setText(med2);
        TextView u3email = findViewById(R.id.m3);
        u3email.setText(med3);
        TextView u4email = findViewById(R.id.m4);
        u4email.setText(med4);
        TextView u5email = findViewById(R.id.m5);
        u5email.setText(med5);

        //TextView m_age = findViewById(R.id.mAge);
        //m_age.setText(userid);
    }


}

