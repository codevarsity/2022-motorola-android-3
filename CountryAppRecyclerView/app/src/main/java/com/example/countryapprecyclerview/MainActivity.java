package com.example.countryapprecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> countries = new ArrayList<>();
    RecyclerView countriesRecyclerView;
    CountriesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        countriesRecyclerView = findViewById(R.id.countriesRecyclerView);

        //we need to attach an adapter to the recycler view
        adapter = new CountriesAdapter(this, countries);

        //layoutmanager
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        countriesRecyclerView.setLayoutManager(manager);
        countriesRecyclerView.setAdapter(adapter);

    }

    void initialize() {
        countries.add("India");
        countries.add("Malaysia");
        countries.add("Singapore");
        countries.add("China");
    }
}