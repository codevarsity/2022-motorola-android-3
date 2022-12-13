package com.example.activityessentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ActivityA extends AppCompatActivity {

    EditText messageEditText;
    Button sendButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        //get reference to objects in the view tree
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener((view)->{
            //get the text that the user has typed
            String message = messageEditText.getText().toString();

            //create intent to launch ActivityB
            Intent intent = new Intent(ActivityA.this, ActivityB.class);

            //attach the message as extra to the intent
            intent.putExtra("MESSAGE", message);
            startActivity(intent);
        });

     }
}