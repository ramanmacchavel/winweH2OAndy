package com.example.h20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;

import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {

    //declaration here
    private EditText txt_mobile;
    private Button buttonSubmit;
    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing awesomevalidation object
       awesomeValidation = new AwesomeValidation(ValidationStyle.UNDERLABEL);
       awesomeValidation.setContext(this);
        //initializing view objects
        txt_mobile = (EditText) findViewById(R.id.txt_MobileNumber);
        buttonSubmit = (Button) findViewById(R.id.btn_Login);
        //adding validation to edittexts
        awesomeValidation.addValidation(this, R.id.txt_MobileNumber, "^[2-9]{2}[0-9]{8}$", R.string.MobileNumberError);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        //first validate the form then move ahead
        //if this becomes true that means validation is successfull
        if (awesomeValidation.validate()) {
            //Toast.makeText(this, "Validation Successfull", Toast.LENGTH_LONG).show();
            Intent openOtp = new Intent(this,OtpVerification.class);
            startActivity(openOtp);
            //process the data further
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        checkSession();
    }

    public void homeActivity(){

            if(awesomeValidation.validate()){
                Intent openOtp = new Intent(this, OtpVerification.class);
                startActivity(openOtp);
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