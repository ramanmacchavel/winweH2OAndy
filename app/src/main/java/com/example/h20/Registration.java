package com.example.h20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;

public class Registration extends AppCompatActivity {

    // Declaration
    private TextView txt_Name, txt_Plot, txt_Area, txt_Pin;
    private Button Register;
    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        awesomeValidation = new AwesomeValidation(ValidationStyle.UNDERLABEL);
        awesomeValidation.setContext(this);

        //initializing view objects
        txt_Name = (EditText) findViewById(R.id.txt_Name);
        txt_Plot = (EditText) findViewById(R.id.txt_Street_plot);
        txt_Area = (EditText) findViewById(R.id.txt_Area);
        txt_Pin = (EditText) findViewById(R.id.txt_Pin);

        Register = (Button) findViewById(R.id.btn_Register);


        //adding validation to edittexts
        awesomeValidation.addValidation(this, R.id.txt_Name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.NameError);
        awesomeValidation.addValidation(this, R.id.txt_Street_plot, "", R.string.PlotError);
        awesomeValidation.addValidation(this, R.id.txt_Area, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.AreaError);
        awesomeValidation.addValidation(this, R.id.txt_Pin, "", R.string.AreaError);

       Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });
    }
    private void openMain(){


       if(awesomeValidation.validate()){
           int id = 0, mobilenumber = 0, deviceid = 0;
           // String mobilenumber = null, deviceid = null;

           User user = new User(id, mobilenumber,deviceid);
           //create session
           SessionManagement sessionManagement = new SessionManagement(Registration.this);
           sessionManagement.saveSession(user);
           //OPen next Activity
           openHomeActivity();

        }

    }
    public void openHomeActivity(){
        //for get device id
        String ID = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);
       // Toast.makeText(getApplicationContext(), ""+ ID.toString(),Toast.LENGTH_LONG).show();
        Intent openmainintent = new Intent(this, Home.class);
        openmainintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(openmainintent);
    }
}