package com.example.activityessentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ActivityD extends AppCompatActivity {

    EditText messageEditText;
    Button doneButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);

        messageEditText = findViewById(R.id.messageEditText);
        doneButton = findViewById(R.id.doneButton);
        doneButton.setOnClickListener((view)->{
            String message = messageEditText.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("MESSAGE", message);

            //send the intent to the parent activity
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