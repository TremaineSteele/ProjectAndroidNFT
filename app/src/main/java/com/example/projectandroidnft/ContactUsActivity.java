package com.example.projectandroidnft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ContactUsActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4, ed5;
    Button btn1,goback5;

    FirebaseDatabase database;
    DatabaseReference reference;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        username = getIntent().getStringExtra("username");

        ed1 = findViewById(R.id.edtFn);
        ed2 = findViewById(R.id.edtLn);
        ed3 = findViewById(R.id.edtEmail);
        ed4 = findViewById(R.id.edtMess);
        ed5 = findViewById(R.id.edtDisplay);
        btn1 = findViewById(R.id.btnSubmit);
        goback5 = findViewById(R.id.goback5);


        goback5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ContactUsActivity.this,UserMainPage.class);
                i.putExtra("username",username);
                startActivity(i);
                finish();


            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("messages");

                String fnstr = ed1.getText().toString();
                String lnstr = ed2.getText().toString();
                String emstr = ed3.getText().toString();
                String messtr = ed4.getText().toString();
                //String result = ed5.getText().toString();

                if(fnstr.isEmpty()||lnstr.isEmpty()||emstr.isEmpty()||messtr.isEmpty()){
                    Toast.makeText(ContactUsActivity.this, "All fields should be field", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    ContactUsModel model = new ContactUsModel(fnstr,lnstr,emstr,messtr);
                    reference.child(fnstr).setValue(model);
                    Toast.makeText(ContactUsActivity.this, "Message sent", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(ContactUsActivity.this,UserMainPage.class);
                    intent.putExtra("username",username);
                    startActivity(intent);
                    finish();


                }

                ed5.setText("Thank you " + fnstr + "your message will answered within 24 hours");

                ed1.getText().clear();
                ed2.getText().clear();
                ed3.getText().clear();
                ed4.getText().clear();



            }
        });

    }
}