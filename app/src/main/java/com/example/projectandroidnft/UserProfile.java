package com.example.projectandroidnft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity {



    TextView pName,pEmail,pUsername;

    Button signOut,goBack;

    String username;

    FirebaseDatabase database;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        username = getIntent().getStringExtra("username");



        pName = findViewById(R.id.txtviewname);
        pEmail = findViewById(R.id.txtviewemail);
       pUsername= findViewById(R.id.txtviewusername);


        signOut = findViewById(R.id.signoutBtn);
       goBack = findViewById(R.id.goBack3);

       DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference("users").child(username);



       reference1.addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               if (snapshot.exists()) {
                   Model model = snapshot.getValue(Model.class);
                   pName.setText(model.firstName + " " + model.lastName);
                   pEmail.setText(model.email);
                   pUsername.setText(model.username);

               }
           }


           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });


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
                i.putExtra("username",username);
                startActivity(i);
                finish();
            }
        });

    }
}