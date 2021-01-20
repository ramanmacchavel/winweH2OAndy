package com.example.h20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {
    //Declaration
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    RecyclerView recyclerView;
    List<Hero> hero;
    HomeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //for recycler view
        recyclerView = findViewById(R.id.movielist);
        //for nav
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nav=(NavigationView)findViewById(R.id.navmenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.Open, R.string.Close );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        callmovie();
    }
    @Override
    public boolean onCreateOptionsMenu( Menu menu) {
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
                        recreate();
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
    @Override
    protected void onResume() {

        super.onResume();
        callmovie();
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
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
    private void callmovie() {
        if(!isNetworkConnected()) {
            Toast.makeText(Home.this, "No Internet", Toast.LENGTH_SHORT).show();
        }else{
            Call<List<Hero>> call = RetrofitClass.getInstance().getMyApi().gethero();
            call.enqueue(new Callback<List<Hero>>() {
                @Override
                public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                    List<Hero> heroList = response.body();
                    recyclerView.setLayoutManager(new LinearLayoutManager(Home.this));
                    adapter = new HomeAdapter(Home.this, heroList);
                    recyclerView.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<List<Hero>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
    public void logoutapp(){

        SessionManagement sessionManagement = new SessionManagement(Home.this);
        sessionManagement.removeSession();
        openMain();
    }
    public void openMain(){
        Intent openamainintent = new Intent(Home.this, MainActivity.class);
        openamainintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(openamainintent);
    }

}