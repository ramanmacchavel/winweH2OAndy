package com.example.h20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Registration extends AppCompatActivity {

    // Declaration
    TextView Txt_Name, Txt_Plot, Txt_Area, Txt_Pin;
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
       // String Name = Txt_Name.getText().toString();
       // String Plot = Txt_Plot.getText().toString();
      //  String Ares = Txt_Area.getText().toString();
       // String Pin = Txt_Pin.getText().toString();
        try{
            Intent openmainintent = new Intent(this, Home.class);
            startActivity(openmainintent);
        }
        catch (Exception e){

        }
    }
}