package com.example.applicationessentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void makePhoneCall(View view) {
        //implicit
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    public void takePicture(View view) {
        //implicit intent
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    public void launchWeb(View view) {

        //implicit intent with data attached to it
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.google.com"));
        startActivity(intent);
    }


    public void launchSecond(View view) {
        //explicit intent
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}