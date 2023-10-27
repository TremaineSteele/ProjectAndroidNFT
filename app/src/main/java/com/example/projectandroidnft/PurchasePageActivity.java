package com.example.projectandroidnft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

public class PurchasePageActivity extends AppCompatActivity {

    CheckBox ch1,ch2,ch3,ch4,ch5,ch6;
    Button   bt1,bt2,bt3,bt4,bt5,bt6,goBackBtn;

    ImageView im1,im2,im3,im4,im5,im6;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_page);
        username = getIntent().getStringExtra("username");

        //all checkboxes linked
        ch1 = findViewById(R.id.nft1);
        ch2 = findViewById(R.id.nft2);
        ch3 = findViewById(R.id.nft3);
        ch4 = findViewById(R.id.nft4);
        ch5 = findViewById(R.id.nft5);
        ch6 = findViewById(R.id.nft6);

        //all buttons linked
        bt1 = findViewById(R.id.nftBut1);
        bt2 = findViewById(R.id.nftBut2);
        bt3 = findViewById(R.id.nftBut3);
        bt4 = findViewById(R.id.nftBut4);
        bt5 = findViewById(R.id.nftBut5);
        bt6 = findViewById(R.id.nftBut6);

        goBackBtn = findViewById(R.id.goBackButton);
        //All images linked
        im1 = findViewById(R.id.image1);
        im2 = findViewById(R.id.image2);
        im3 = findViewById(R.id.image3);
        im4 = findViewById(R.id.image4);
        im5 = findViewById(R.id.image5);
        im6 = findViewById(R.id.image6);



        

        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PurchasePageActivity.this,UserMainPage.class);
                intent.putExtra("username",username);
                startActivity(intent);
                finish();
                }
        });



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch1.isChecked()){

                    //trying to transfer image to next page
                    im1.setDrawingCacheEnabled(true);
                    im1.buildDrawingCache();
                    Bitmap bitmap = ((BitmapDrawable) im1.getDrawable()).getBitmap();
                    Intent i = new Intent(PurchasePageActivity.this,MainActivity.class );
                    i.putExtra("bitmap", bitmap);
                    startActivity(i);
                    finish();

                }else{
                    Toast.makeText(PurchasePageActivity.this, "Must Have correct Box Checked", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch2.isChecked()){

                    im2.setDrawingCacheEnabled(true);
                    im2.buildDrawingCache();
                    Bitmap bitmap = ((BitmapDrawable) im2.getDrawable()).getBitmap();
                    Intent i = new Intent(PurchasePageActivity.this,MainActivity.class );
                    i.putExtra("bitmap", bitmap);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(PurchasePageActivity.this, "Must Have correct Box Checked", Toast.LENGTH_SHORT).show();
                }


            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch3.isChecked()){

                    im3.setDrawingCacheEnabled(true);
                    im3.buildDrawingCache();
                    Bitmap bitmap = ((BitmapDrawable) im3.getDrawable()).getBitmap();
                    Intent i = new Intent(PurchasePageActivity.this,MainActivity.class );
                    i.putExtra("bitmap", bitmap);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(PurchasePageActivity.this, "Must Have correct Box Checked", Toast.LENGTH_SHORT).show();
                }


            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch4.isChecked()){

                    im4.setDrawingCacheEnabled(true);
                    im4.buildDrawingCache();
                    Bitmap bitmap = ((BitmapDrawable) im4.getDrawable()).getBitmap();
                    Intent i = new Intent(PurchasePageActivity.this,MainActivity.class );
                    i.putExtra("bitmap", bitmap);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(PurchasePageActivity.this, "Must Have correct Box Checked", Toast.LENGTH_SHORT).show();
                }


            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch5.isChecked()){

                    im5.setDrawingCacheEnabled(true);
                    im5.buildDrawingCache();
                    Bitmap bitmap = ((BitmapDrawable) im5.getDrawable()).getBitmap();
                    Intent i = new Intent(PurchasePageActivity.this,MainActivity.class );
                    i.putExtra("bitmap", bitmap);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(PurchasePageActivity.this, "Must Have correct Box Checked", Toast.LENGTH_SHORT).show();
                }


            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch6.isChecked()){

                    im6.setDrawingCacheEnabled(true);
                    im6.buildDrawingCache();
                    Bitmap bitmap = ((BitmapDrawable) im6.getDrawable()).getBitmap();
                    Intent i = new Intent(PurchasePageActivity.this,MainActivity.class );
                    i.putExtra("bitmap", bitmap);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(PurchasePageActivity.this, "Must Have correct Box Checked", Toast.LENGTH_SHORT).show();
                }


            }
        });




    }
}