package com.example.h20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OtpVerification extends AppCompatActivity {

    //Declaration
    TextView Txt_Otp, Otp_Err_label;
    Button Btn_OtpVerify;

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
        Otp_Err_label = findViewById(R.id.otp_err_Label);
        try {
            if (TxtOtp.isEmpty()) {
                Otp_Err_label.setText("Enter you otp");
            } else {
                Intent openRegintent = new Intent(this, Registration.class);
                startActivity(openRegintent);
            }
        } catch (Exception e) {

        }
    }
}