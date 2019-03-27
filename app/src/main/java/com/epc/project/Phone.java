package com.epc.project;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Phone extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        Button save=(Button) findViewById(R.id.save);
        final EditText phone1= (EditText)findViewById(R.id.phone1);
        final EditText phone2= (EditText)findViewById(R.id.phone2);
        final String KEY_ID = "id";
        final String KEY_NAME = "name";
        final String KEY_PH_NO1 = "phone_number1";
        final String KEY_PH_NO2 = "phone_number2";
        final DatabaseHandler db = new DatabaseHandler(this);
        List<Contact> entries=db.getAllContacts();

        if(entries.size()!=0)
        {
            Contact link=db.getContact(1);
            String number1=link.getName();
            phone1.setText(number1);
            phone2.setText(number1);
        }
        save.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                String number2=phone1.getText().toString();
                String number3=phone2.getText().toString();
                //db.addContact(new Contact(" ", number));
                if(number2.length()==0)
                {
                    Toast.makeText(Phone.this, "Please enter a Phone Number", Toast.LENGTH_SHORT).show();
                }
                if(number3.length()==0)
                {
                    Toast.makeText(Phone.this, "Please enter a Phone Number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    List<Contact> entries2=db.getAllContacts();
                    if(entries2.size()==0)
                    {
                        db.addContact(new Contact("123", "", ""));
                    }
                    db.updateContact(new Contact(number2, "", ""));

                    Toast.makeText(Phone.this, "Phone Number Saved", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }



}
