package com.example.h20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;

public class OtpVerification extends AppCompatActivity {

    //Declaration
    private TextView Txt_Otp, Otp_Err_label;
    private  Button Btn_OtpVerify;
    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        Btn_OtpVerify = findViewById(R.id.btn_OtpVerify);
        Btn_OtpVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhomeActivity();
            }
        });
    }

    private void openhomeActivity() {
        Txt_Otp = findViewById(R.id.txt_Otp);
        String TxtOtp = Txt_Otp.getText().toString();
        try {
            if (TxtOtp.isEmpty()) {
            } else {
                Intent openRegintent = new Intent(this, Registration.class);
                startActivity(openRegintent);
            }
        } catch (Exception e) {

        }
    }
}