package com.example.projectandroidnft;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edtCreditcard,edtNameOnCard,edtSecurityCode;
    TextView expdate;

    Button confirmPurchase,datepickerBtn,goBack2;
    String username;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = getIntent().getStringExtra("username");

        Intent intent = getIntent();
        if (intent.hasExtra("bitmap")) {
            Bitmap bitmap = (Bitmap) intent.getParcelableExtra("bitmap");

            ImageView imageView = findViewById(R.id.purchaseImage);
            imageView.setImageBitmap(bitmap);
        }


        edtCreditcard = findViewById(R.id.edtCreditCard);
        edtNameOnCard = findViewById(R.id.edtNameOnCard);
        expdate = findViewById(R.id.expDateTxt);
        edtSecurityCode = findViewById(R.id.edtsecurityCode);
        goBack2 = findViewById(R.id.gobackBtn2);
        confirmPurchase = findViewById(R.id.confirmPurchaseBtn);
        datepickerBtn = findViewById(R.id.datepicker);

        String creditcard = edtCreditcard.getText().toString();
        String nameoncard = edtNameOnCard.getText().toString();
        String securCode = edtSecurityCode.getText().toString();
        String date = expdate.getText().toString();

            goBack2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, UserMainPage.class);
                    i.putExtra("username",username);
                    startActivity(i);
                    finish();
                }
            });
        datepickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDate();


            }
        });

        confirmPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // if(creditcard.isEmpty() || nameoncard.isEmpty() || date.isEmpty() || securCode.isEmpty()){{
                    //Toast.makeText(MainActivity.this, "Fields must not be empty", Toast.LENGTH_SHORT).show();
                //}

                    Toast.makeText(MainActivity.this, "Purchase Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, UserMainPage.class);
                   i.putExtra("username",username);
                    startActivity(i);
                    finish();

                }


        });

    }

    private void showDate() {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(

                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        String selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                        expdate.setText(selectedDate);

                    }
                },
                year, month, day);


        datePickerDialog.show();
    }
}

