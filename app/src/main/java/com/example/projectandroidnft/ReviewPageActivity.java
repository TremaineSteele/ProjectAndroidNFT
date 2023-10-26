package com.example.projectandroidnft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.ref.Reference;

public class ReviewPageActivity extends AppCompatActivity {

    Button submitBtn,goback4;
    RatingBar rat1,rat2,rat3,rat4,rat5,rat6;

    DatabaseReference databaseReference;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_page);


        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("ratings");
        goback4 =findViewById(R.id.goBack4);

        submitBtn = findViewById(R.id.submitRatingButton);
        rat1 = findViewById(R.id.rating1);
        rat2 = findViewById(R.id.rating2);
        rat3 = findViewById(R.id.rating3);
        rat4 = findViewById(R.id.rating4);
        rat5 = findViewById(R.id.rating5);
       // rat6 = findViewById(R.id.rating6);

        goback4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ReviewPageActivity.this,UserMainPage.class);
                startActivity(i);
                finish();
            }
        });

        rat1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(ReviewPageActivity.this, "Thank you for rating", Toast.LENGTH_SHORT).show();
            }
        });

        rat2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(ReviewPageActivity.this, "Thank you for rating", Toast.LENGTH_SHORT).show();
            }
        });


        rat3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(ReviewPageActivity.this, "Thank you for rating", Toast.LENGTH_SHORT).show();
            }
        });


        rat4.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(ReviewPageActivity.this, "Thank you for rating", Toast.LENGTH_SHORT).show();
            }
        });


        rat5.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(ReviewPageActivity.this, "Thank you for rating", Toast.LENGTH_SHORT).show();
            }
        });


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(ReviewPageActivity.this, "You have submitted your rating", Toast.LENGTH_SHORT).show();
                databaseReference = FirebaseDatabase.getInstance().getReference().child("ratings");

                float rating1 = rat1.getRating();
                float rating2 = rat2.getRating();
               float rating3 = rat3.getRating();
               float rating4 = rat4.getRating();
               float rating5 = rat5.getRating();

                RatingModel ratingModel = new RatingModel(rating1);
                RatingModel ratingModel2 = new RatingModel(rating2);
                RatingModel ratingModel3 = new RatingModel(rating3);
                RatingModel ratingModel4 = new RatingModel(rating4);
                RatingModel ratingModel5 = new RatingModel(rating5);

                    if (rating1 > 0){
                        databaseReference.push().setValue(rating1);

                    }
                if (rating2 > 0){
                    databaseReference.push().setValue(rating2);

                }
                if (rating3 > 0){
                    databaseReference.push().setValue(rating3);

                }
                if (rating4 > 0){
                    databaseReference.push().setValue(rating4);

                }
                if (rating5 > 0){
                    databaseReference.push().setValue(rating5);

                }else if(rating1==0||rating2==0||rating3==0||rating4==0||rating5==0){
                    Toast.makeText(ReviewPageActivity.this, "Please Rate all options", Toast.LENGTH_SHORT).show();
                }


                Intent i = new Intent(ReviewPageActivity.this, UserMainPage.class);
                startActivity(i);
                finish();


            }
        });






    }
}