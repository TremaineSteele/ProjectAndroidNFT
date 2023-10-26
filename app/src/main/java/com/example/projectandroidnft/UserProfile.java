package com.example.projectandroidnft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserProfile extends AppCompatActivity {



    TextView pName,pEmail,pUsername;

    Button signOut,goBack;

    FirebaseDatabase database;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        pName = findViewById(R.id.txtviewusername);
        pEmail = findViewById(R.id.txtviewemail);
       pUsername= findViewById(R.id.txtviewusername);


        signOut = findViewById(R.id.signoutBtn);
       goBack = findViewById(R.id.goBack3);

        showData();


        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserProfile.this,LogInActivity.class);
                startActivity(i);
                finish();

            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserProfile.this, UserMainPage.class);
                startActivity(i);
                finish();
            }
        });

    }

    public void showData(){

        
        String txtname = pName.toString();
        String txtemail = pEmail.toString();
        String txtusername = pUsername.toString();

        Intent intent = getIntent();
        txtname = intent.getStringExtra("name");
        txtemail = intent.getStringExtra("email");
        txtusername = intent.getStringExtra("username");

        pName.setText(txtname);
        pEmail.setText(txtemail);
        pUsername.setText(txtusername);




    }
}