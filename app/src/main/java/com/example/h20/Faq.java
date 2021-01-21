package com.example.h20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class Faq extends AppCompatActivity {

    //Declaration
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nav=(NavigationView)findViewById(R.id.navmenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.Open, R.string.Close );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.iconmenu, menu);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.menu_home :
                        //Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_LONG).show();
                        openhome();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_myaccount :
                        // Toast.makeText(getApplicationContext(),"My Account", Toast.LENGTH_LONG).show();
                        openmyaccount();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_mycart :
                        //Toast.makeText(getApplicationContext(),"mycart  Open",Toast.LENGTH_LONG).show();
                        openmycart();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_myorder :
                        // Toast.makeText(getApplicationContext(),"my order",Toast.LENGTH_LONG).show();
                        openmyorder();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_customerservice :
                        // Toast.makeText(getApplicationContext(),"customer service",Toast.LENGTH_LONG).show();
                        opencustomerservice();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_faq :
                        //Toast.makeText(getApplicationContext(),"faq",Toast.LENGTH_LONG).show();
                        recreate();
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
        return false;
    }
    public void openhome(){
        try{
            Intent homeintent = new Intent(this, Home.class);
            startActivity(homeintent);
        }catch (Exception e){

        }
    }

    public void openmyaccount() {
        try{
            Intent myaccountintent = new Intent(this, MyAccount.class);
            startActivity(myaccountintent);
        }catch (Exception e){

        }
    }
    public void openmycart() {
        try {
            Intent mycartintent = new Intent(this, MyCart.class);
            startActivity(mycartintent);
        }catch (Exception e){

        }
    }
    public void openmyorder(){
        try{
            Intent myorderintent = new Intent(this, MyOrder.class);
            startActivity(myorderintent);
        }catch (Exception e){

        }
    }
    public void opencustomerservice(){
        try{
            Intent customercareintent = new Intent(this, CustomerCare.class);
            startActivity(customercareintent);
        }catch (Exception e){

        }
    }
    public void openfaq(){
        try{
            Intent faqintent = new Intent(this, Faq.class);
            startActivity(faqintent);
        }catch(Exception e){

        }
    }
    public void logoutapp(){

        SessionManagement sessionManagement = new SessionManagement(Faq.this);
        sessionManagement.removeSession();
        openMain();
    }
    public void openMain(){
        Intent openamainintent = new Intent(Faq.this, MainActivity.class);
        openamainintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(openamainintent);
    }

}