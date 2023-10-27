package com.example.projectandroidnft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserMainPage extends AppCompatActivity {

    TextView usernameTop;

    Button  btnProfile,btnPurchase,btnContact,btnReview,btnLogOut;
    String username,name,email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_page);
        btnProfile = findViewById(R.id.userViewProfile);
        btnPurchase = findViewById(R.id.userPurchase);
        btnContact =findViewById(R.id.userContact);
        btnReview = findViewById(R.id.userReview);
        btnLogOut = findViewById(R.id.userLogOut);
        usernameTop = findViewById(R.id.userFromLogin);

        Intent intent = getIntent();
        username = intent.getStringExtra("username");

        Toast.makeText(UserMainPage.this, username, Toast.LENGTH_SHORT).show();

        showUsername();


       btnLogOut.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(UserMainPage.this,LogInActivity.class);
               startActivity(i);
               finish();

           }
       });


       btnProfile.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intentSender = new Intent(UserMainPage.this, UserProfile.class);
               intentSender.putExtra("username", username);
               startActivity(intentSender);
               finish();

           }
       });

       btnReview.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v2) {
               Intent i = new Intent(UserMainPage.this,ReviewPageActivity.class);
               i.putExtra("username", username);
               startActivity(i);
               finish();



           }
       });


       btnContact.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v3) {
               Intent i = new Intent(UserMainPage.this,ContactUsActivity.class);
               i.putExtra("username", username);
               startActivity(i);
               finish();
           }
       });


       btnPurchase.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(UserMainPage.this, PurchasePageActivity.class);
               i.putExtra("username", username);
               startActivity(i);
               finish();
           }
       });


    }

    public void showUsername() {
        Intent intent = getIntent();
        String name= intent.getStringExtra("name");

        usernameTop.setText(name);
    }



}