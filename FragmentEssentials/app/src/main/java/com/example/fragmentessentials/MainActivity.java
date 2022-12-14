package com.example.fragmentessentials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragmentA();

    }

    void loadFirstFragment() {
        FirstFragment ff = new FirstFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.mainLayout, ff, "FF")
                .commit();
    }

    void loadFragmentA() {
        FragmentA ff = new FragmentA();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.mainLayout, ff, "FF")
                .commit();
    }

    /*
    void loadBackgroundFragment() {
        BackgroundFragment bgf = new BackgroundFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction addFragmentTransaction = fragmentManager.beginTransaction();
        addFragmentTransaction.add(bgf, "BGF");
        addFragmentTransaction.commit();
    }
     */
}