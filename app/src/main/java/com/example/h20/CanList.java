package com.example.h20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class CanList extends AppCompatActivity {

    //for nav drawer
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    //for recyler view
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_list);
        recyclerView = findViewById(R.id.canlist);
        //for nav drawer
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
                // getMenuInflater().inflate(R.menu.iconmenu, menuItem);
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
                        openfaq();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_logout :
                        // Toast.makeText(getApplicationContext(),"faq",Toast.LENGTH_LONG).show();
                        logoutapp();
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                }
                return true;
            }
        });
        return false;
    }
    public void openhome() {
        try{
            Intent homeintent = new Intent(this, Home.class);
            startActivity(homeintent);
        }catch (Exception e){

        }
    }

    public void openmyaccount() {
        try {
            Intent accountintent = new Intent(this, MyAccount.class);
            startActivity(accountintent);
        }catch (Exception e){

        }
    }

    public void openmyorder() {
        try{
            Intent orderintent = new Intent(this, MyOrder.class);
            startActivity(orderintent);
        }catch (Exception e){

        }
    }
    public void openmycart() {
        try{
            Intent mycartrintent = new Intent(this, MyCart.class);
            startActivity(mycartrintent);
        }catch (Exception e){

        }
    }

    public void opencustomerservice() {
        try{
            Intent customerintent = new Intent(this, CustomerCare.class);
            startActivity(customerintent);
        }catch (Exception e){

        }
    }

    public void openfaq() {
        try{
            Intent faqintent = new Intent(this, Faq.class);
            startActivity(faqintent);
        }catch (Exception e){

        }
    }
    public void logoutapp(){

        SessionManagement sessionManagement = new SessionManagement(CanList.this);
        sessionManagement.removeSession();
        openMain();
    }
    public void openMain(){
        Intent openamainintent = new Intent(CanList.this, MainActivity.class);
        openamainintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(openamainintent);
    }
}
