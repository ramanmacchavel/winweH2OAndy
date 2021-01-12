package com.example.h20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MyAccount extends AppCompatActivity {

    //Declaration
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav=(NavigationView)findViewById(R.id.navmenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.Open, R.string.Close );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.menu_home :
                       // Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_LONG).show();
                        openhome();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_myaccount :
                        //Toast.makeText(getApplicationContext(),"My Account", Toast.LENGTH_LONG).show();
                        recreate();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_mycart :
                        //Toast.makeText(getApplicationContext(),"mycart  Open",Toast.LENGTH_LONG).show();
                        openmycart();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_myorder :
                        //Toast.makeText(getApplicationContext(),"my order",Toast.LENGTH_LONG).show();
                        openmyorder();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_customerservice :
                        //Toast.makeText(getApplicationContext(),"customer service",Toast.LENGTH_LONG).show();
                        opencustomerservice();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_faq :
                        //Toast.makeText(getApplicationContext(),"faq",Toast.LENGTH_LONG).show();
                        openfaq();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_logout :
                        //Toast.makeText(getApplicationContext(),"faq",Toast.LENGTH_LONG).show();
                        logoutapp();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                return true;
            }
        });
    }
    public void openhome(){
        try{
            Intent homeintent =  new Intent(this, Home.class);
             startActivity(homeintent);
        }catch(Exception e){

        }
    }
    public void openmycart(){
        try {
            Intent cartintent = new Intent(this, MyCart.class);
            startActivity(cartintent);
        }catch (Exception e){

        }
    }
    public void openmyorder(){
        try{
            Intent orderintent = new Intent(this, MyOrder.class);
            startActivity(orderintent);
        }catch(Exception e){

        }
    }
    public void opencustomerservice(){
        try{
            Intent customnerintent = new Intent(this, CustomerCare.class);
            startActivity(customnerintent);
        }catch(Exception e){

        }
    }
    public void openfaq(){
        try{
            Intent faqintent = new Intent(this, Faq.class);
            startActivity(faqintent);
        }catch (Exception e){

        }
    }
    public void logoutapp(){

        SessionManagement sessionManagement = new SessionManagement(MyAccount.this);
        sessionManagement.removeSession();
        openMain();
    }
    public void openMain(){
        Intent openamainintent = new Intent(MyAccount.this, MainActivity.class);
        openamainintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(openamainintent);
    }
}