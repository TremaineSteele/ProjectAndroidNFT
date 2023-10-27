package com.example.projectandroidnft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    TextView logBackLink;
    EditText edtFirstName, edtLastName, edtEmail, edtUsername, edtPassword, edtConfirm;

    Button regBtn;

    FirebaseDatabase database;

    //needed to make table in database
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        logBackLink = findViewById(R.id.logBackIn);

        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        edtEmail = findViewById(R.id.edtEmail);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirm = findViewById(R.id.edtConfirmPassword);
        regBtn = findViewById(R.id.registerBtn);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //created database
                database = FirebaseDatabase.getInstance();

                //created table called users
                reference = database.getReference("users");

                //creating strings to send data to database

                String firstnameUser = edtFirstName.getText().toString().trim();
                String lastnameUser = edtLastName.getText().toString().trim();
                String emailUser = edtEmail.getText().toString().trim();
                String userUsername = edtUsername.getText().toString().trim();
                String userPassword = edtPassword.getText().toString().trim();
                String confirmPassword = edtConfirm.getText().toString().trim();

                //create model for user(database info)
                //create java class only
                //---------------------------------------------------------------

                //make sure no empty
                if (userUsername.isEmpty() || emailUser.isEmpty() || userPassword.isEmpty() || confirmPassword.isEmpty() || firstnameUser.isEmpty() || lastnameUser.isEmpty()) {

                    Toast.makeText(SignUpActivity.this, "Fill in all the fields", Toast.LENGTH_SHORT).show();

                } else {
                    //created model for table
                    Model model = new Model(firstnameUser, lastnameUser, emailUser, userUsername, userPassword, confirmPassword);

                    //setting primary key as username
                    reference.child(userUsername).setValue(model);
                    Toast.makeText(SignUpActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, UserMainPage.class);
                    intent.putExtra("username",userUsername);
                    intent.putExtra("name",firstnameUser);
                    intent.putExtra("email",emailUser);

                    startActivity(intent);
                    finish();

                }

            }
        });


        logBackLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,LogInActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }
}







