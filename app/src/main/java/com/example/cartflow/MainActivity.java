package com.example.cartflow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NavController navController= Navigation.findNavController(this,R.id.my_nav_host_fragment);
        // NavigationUI.setupActionBarWithNavController(this,Navigation.findNavController(this,R.id.my_nav_host_fragment));
        BottomNavigationView navigationView=findViewById(R.id.bottom_nav);
        //NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("ResourceType")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        navController.navigate(R.id.home_fragment);
                        break;
                    case R.id.categories:
                        navController.navigate(R.id.categories_fragment);
                        break;
                    case R.id.profile:
                        //navController.navigate(R.id.profile_fragment);
                        Intent intent2=new Intent(MainActivity.this,ProfileActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id._carts:
                        navController.navigate(R.id.cart_fragment);
                        break;
                    case R.id._sells:
                        //navController.navigate(R.id.sell_fragment);
                        Intent intent=new Intent(MainActivity.this,SellActivity.class);
                        startActivity(intent);
                        break;

                }
                return true;
            }
        });
    }
}