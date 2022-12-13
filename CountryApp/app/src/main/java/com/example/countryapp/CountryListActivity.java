package com.example.countryapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;

public class CountryListActivity extends AppCompatActivity {

    ArrayList<String> countryNames = new ArrayList<>();
    TextView countryListTextView;
    Button addCountryButton;


    void initializeCountries() {
        countryNames.add("India");
        countryNames.add("Malaysia");
        countryNames.add("China");
        countryNames.add("Singapore");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);
        countryListTextView = findViewById(R.id.countryListTextView);
        addCountryButton = findViewById(R.id.addCountryButton);
        addCountryButton.setOnClickListener((view)->{
            Intent intent = new Intent(CountryListActivity.this, AddCountryActivity.class);
            startActivityForResult(intent, 101);
        });

        if(savedInstanceState == null) {
            initializeCountries();
        } else {
            countryNames = savedInstanceState.getStringArrayList("COUNTRY_NAMES");
        }


        String countries = arrayToString(countryNames);
        countryListTextView.setText(countries);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 && resultCode == RESULT_OK && data != null) {
            String countryName = data.getStringExtra("COUNTRY_NAME");
            countryNames.add(countryName);
            //update the text view
            String countries = arrayToString(countryNames);
            countryListTextView.setText(countries);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("COUNTRY_NAMES", countryNames);
    }

    String arrayToString(ArrayList<String> items) {
        StringBuilder builder = new StringBuilder();
        for(String item : items) {
            builder.append(item);
            builder.append("\n");
        }
        return builder.toString();
    }
}