package com.example.h20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Registration extends AppCompatActivity {

    // Declaration
    TextView Txt_Name, Txt_Plot, Txt_Area, Txt_Pin, Txt_error_name, Txt_error_plot, Txt_error_area, Txt_error_pin ;
    Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Register = findViewById(R.id.btn_Register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });
    }
    private void openMain(){
        Txt_Name = findViewById(R.id.txt_Name);
        Txt_Plot = findViewById(R.id.txt_Street_plot);
        Txt_Area = findViewById(R.id.txt_Area);
        Txt_Pin = findViewById(R.id.txt_Pin);
        Txt_error_name = findViewById(R.id.err_Label_name);
        Txt_error_plot = findViewById(R.id.err_Label_plot);
        Txt_error_area = findViewById(R.id.err_Label_area);
        Txt_error_pin = findViewById(R.id.err_Label_pin);
        String Name = Txt_Name.getText().toString();
        String plot = Txt_Plot.getText().toString();
        String Area = Txt_Area.getText().toString();
        String pin = Txt_Pin.getText().toString();

    try{
        if(Name.isEmpty()){
            Txt_error_name.setText("Enter your Name");
        }if(plot.isEmpty()){
            Txt_error_plot.setText("Enter your Street/Plot");
        }if(Area.isEmpty()){
            Txt_error_area.setText("Enter your Area");
        }if(pin.isEmpty() || pin.length() <6){
            Txt_error_pin.setText("Enter Your Pin");
        }else{

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
        catch (Exception e){

        }
    }
    public void openHomeActivity(){
        Intent openmainintent = new Intent(this, Home.class);
        openmainintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(openmainintent);
    }
}