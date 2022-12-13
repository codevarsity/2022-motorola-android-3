package com.example.activityessentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    Button eventHandlerButton;
    Button launchMainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MainActivity", "onCreate");
        setContentView(R.layout.activity_main);

        launchMainButton = findViewById(R.id.launchMainButton);
        launchMainButton.setOnClickListener((View)->{
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        });
        eventHandlerButton = findViewById(R.id.eventHandlerButton);
        eventHandlerButton.setOnClickListener((view)-> {
            Log.i("MainActivity", "Button Tapped");
        });

        TextView textView = findViewById(R.id.textView2);
        textView.setText("This is the main activity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "onStop");

        // save the data of the activity
    }

    @Override
        protected void onDestroy() {
            super.onDestroy();
            Log.i("MainActivity", "onDestroy");
        }

    public void launchSecond(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    public void finishButton(View view) {
        finish();
    }
}