package com.example.projectandroidnft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LogInActivity extends AppCompatActivity {

    EditText edtUsername,edtPassword;
    Button logBtn;

    TextView signUplink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        edtUsername = findViewById(R.id.userLog);
        edtPassword = findViewById(R.id.logPassword);
        logBtn = findViewById(R.id.logBtn);
        signUplink = findViewById(R.id.signUpLink);

        signUplink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LogInActivity.this,SignUpActivity.class);
                startActivity(i);
                finish();

            }
        });

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkUser();




            }
        });


    }


    public void checkUser(){
        String usernamelogin = edtUsername.getText().toString().trim();
        String passwordlogin = edtPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkuserdata = reference.orderByChild("username").equalTo(usernamelogin);

        checkuserdata.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){
                    //declaring childs.. and declaring usernames has a child that is password
                    String passFromDB = snapshot.child(usernamelogin).child("password").getValue(String.class);
                    if(passFromDB.equals(passwordlogin)) {

                        String usernameFromDB = snapshot.child(usernamelogin).child("username").getValue(String.class);
                        String lastnameDB = snapshot.child(usernamelogin).child("lastName").getValue(String.class);
                        String firstnameDB = snapshot.child(usernamelogin).child("firstname").getValue(String.class);
                        String passDB = snapshot.child(usernamelogin).child("password").getValue(String.class);
                        String confirmpassDB = snapshot.child(usernamelogin).child("confirm").getValue(String.class);
                        String emailDB = snapshot.child(usernamelogin).child("email").getValue(String.class);

                        String userName = edtUsername.getText().toString().trim();





                        Intent intent = new Intent(LogInActivity.this,UserMainPage.class);
                        intent.putExtra("name",firstnameDB);
                        intent.putExtra("name",lastnameDB);
                        intent.putExtra("email",emailDB);
                        //intent.putExtra("username",usernameFromDB);
                        intent.putExtra("password",passDB);
                        intent.putExtra("confirm",confirmpassDB);
                        intent.putExtra("username",userName);


                        Toast.makeText(LogInActivity.this, "Login Sucess", Toast.LENGTH_SHORT).show();

                        startActivity(intent);
                        finish();



                    }else{
                        Toast.makeText(LogInActivity.this, "Your password is wrong", Toast.LENGTH_SHORT).show();

                    }
                }
                else{
                    Toast.makeText(LogInActivity.this, "User does not exist", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}