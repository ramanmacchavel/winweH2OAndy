package com.example.h20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {
    //Declaration
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
                         Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_LONG).show();
                        //openhome();
                        recreate();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_myaccount :
                         Toast.makeText(getApplicationContext(),"My Account", Toast.LENGTH_LONG).show();
                        //openmyaccount();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_mycart :
                        Toast.makeText(getApplicationContext(),"mycart  Open",Toast.LENGTH_LONG).show();
                        //openmycart();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_myorder :
                         Toast.makeText(getApplicationContext(),"my order",Toast.LENGTH_LONG).show();
                      //  openmyorder();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_customerservice :
                         Toast.makeText(getApplicationContext(),"customer service",Toast.LENGTH_LONG).show();
                        //opencustomerservice();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_faq :
                        Toast.makeText(getApplicationContext(),"faq",Toast.LENGTH_LONG).show();
                        //openfaq();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                return true;
            }
        });


    }
}