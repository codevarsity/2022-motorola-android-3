package com.example.countryapplistview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> countries = new ArrayList<>();
    ListView countryListView;
    CountryAdapter adapter;
    Button addCountryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        countryListView = findViewById(R.id.countryListView);
        addCountryButton = findViewById(R.id.addCountry);
        addCountryButton.setOnClickListener((view)->{
            Intent intent = new Intent(MainActivity.this, AddCountryActivity.class);
            startActivityForResult(intent, 101);
        });

        adapter = new CountryAdapter(this, countries);
        countryListView.setAdapter(adapter);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 && resultCode == RESULT_OK && data != null) {
            String countryName = data.getStringExtra("COUNTRY_NAME");
            countries.add(countryName);
            adapter.notifyDataSetChanged();
        }

    }

    void initialize() {
        countries.add("India");
        countries.add("Malaysia");
        countries.add("Singapore");
        countries.add("China");


    }
}