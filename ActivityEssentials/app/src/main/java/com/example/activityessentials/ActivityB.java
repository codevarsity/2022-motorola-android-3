package com.example.activityessentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    TextView messageReceivedTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        messageReceivedTextView = findViewById(R.id.messageReceivedTextView);

        //get access to the launching intent
        Intent launchingIntent = getIntent();
        String message = launchingIntent.getStringExtra("MESSAGE");
        if(message != null) {
            messageReceivedTextView.setText(message);
        }
    }
}