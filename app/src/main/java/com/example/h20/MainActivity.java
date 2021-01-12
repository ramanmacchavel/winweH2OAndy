package com.example.h20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {

    //declaration here
    TextView Mobile_Number, Err_Label;
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login = findViewById(R.id.btn_Login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeActivity();
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        checkSession();
    }

    public void homeActivity() {
        // Intent openhome = new Intent(this, Home.class );
        //startActivity(openhome);
        Mobile_Number = findViewById(R.id.txt_MobileNumber);
        String MobileNumber = Mobile_Number.getText().toString();
        Err_Label = findViewById(R.id.err_Label);
        try{
            if (MobileNumber.startsWith(String.valueOf(0))) {
                Err_Label.setText("Enter a Valid Mobile Number");
            } else if (MobileNumber.isEmpty()) {
                Err_Label.setText("Enter a Valid Mobile Number");
            }
                else if (MobileNumber.length() < 10){
                Err_Label.setText("Enter a Valid Mobile Number");
            } else {
               Intent openOtp = new Intent(this, OtpVerification.class);
               startActivity(openOtp);
                }
        }
        catch (NullPointerException e){

        }
    }
    private void checkSession(){
        //check if user is logged in
        //if user is logged in --> move to mainActivity

        SessionManagement sessionManagement = new SessionManagement(MainActivity.this);
        int userID = sessionManagement.getSession();

        if(userID != -1){
            //user id logged in and so move to mainActivity
            openHomeActivity();
        }
        else{
            //do nothing
        }
    }
    public void openHomeActivity(){
        Intent intent = new Intent(MainActivity.this, Home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}