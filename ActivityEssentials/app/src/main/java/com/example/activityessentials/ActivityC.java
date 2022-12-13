package com.example.activityessentials;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ActivityC extends AppCompatActivity {

    Button getMessageButton;
    TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        getMessageButton  = findViewById(R.id.getMessageButton);
        getMessageButton.setOnClickListener((view)->{
            Intent intent = new Intent(ActivityC.this, ActivityD.class);
            startActivityForResult(intent, 101);
        });
        messageTextView = findViewById(R.id.messageTextView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 && resultCode == RESULT_OK && data != null) {
            String message = data.getStringExtra("MESSAGE");
            messageTextView.setText(message);
        }
    }
}