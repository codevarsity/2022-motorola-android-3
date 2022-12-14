package com.example.countryapplistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddCountryActivity extends AppCompatActivity {

    EditText countryNameEditText;
    Button doneButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country);

        countryNameEditText = findViewById(R.id.countryNameEditText);
        doneButton = findViewById(R.id.doneButton);
        doneButton.setOnClickListener((view)->{
            String countryName = countryNameEditText.getText().toString();
            Intent intent  = new Intent();
            intent.putExtra("COUNTRY_NAME", countryName);
            setResult(RESULT_OK, intent);
            finish();
        });
        cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener((view)->{
            finish();
        });

    }
}