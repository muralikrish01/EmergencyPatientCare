package com.epc.project;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.telephony.SmsManager;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class sendSms extends Activity{

    DatabaseReference userDB;
    DatabaseReference userPatDB;
    private String uid;
    private String uEc1,uEc2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendsms);

        /*userDB = FirebaseDatabase.getInstance().getReference("users");
        userPatDB = FirebaseDatabase.getInstance().getReference("users").child("Patients");

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            //email = user.getEmail();
            uid = user.getUid();
            //phone = user.getPhoneNumber();
        }

        userPatDB.child(uid).child("PatientsRegDetails").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserDetails ud = dataSnapshot.child("uEc1").getValue(UserDetails.class);
                uEc1 = ud.getuEc1();
                UserDetails ud1 = dataSnapshot.child("uEc2").getValue(UserDetails.class);
                uEc2 = ud1.getuEc2();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }); */
        SmsManager sm = SmsManager.getDefault();
        DatabaseHandler db= new DatabaseHandler(this);
        Bundle extras = getIntent().getExtras();
        String message="";
        if(extras !=null) {
            message = extras.getString("message");

        }
        List<Contact> entries=db.getAllContacts();
        String number="";
        if(entries.size()!=0)
        {
            Contact link=db.getContact(1);
            number=link.getName();
        }
        sm.sendTextMessage(number, null, message, null, null);
        //sm.sendTextMessage(number, null, message, null, null);
        Toast.makeText(sendSms.this, "SMS sent", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), SOSActivity.class);
        startActivity(i);
    }
}
