package com.example.countryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddCountryActivity extends AppCompatActivity {

    EditText addCountryEditText;
    Button doneButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country);

        addCountryEditText = findViewById(R.id.addCountryEditText);
        doneButton = findViewById(R.id.doneButton);
        doneButton.setOnClickListener((view)->{
            String countryName = addCountryEditText.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("COUNTRY_NAME", countryName);
            setResult(RESULT_OK, intent);
            finish();
        });
        cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener((view)->{
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}