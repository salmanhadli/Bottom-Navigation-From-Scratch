package com.example.bottomnavigationfromscratch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    ThirdFragment thirdFragment = new ThirdFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home); // setting default selection
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int selectedId = item.getItemId();

        if (selectedId == R.id.profile) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FLFragment, firstFragment).commit();
            return true;
        }
        if (selectedId == R.id.home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FLFragment, secondFragment).commit();
            return true;
        }
        if (selectedId == R.id.settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FLFragment, thirdFragment).commit();
            return true;
        }
        return false;
    }
}