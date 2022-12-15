package com.example.androidconcurrencyessentials;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityService extends AppCompatActivity {
    Button downloadButton;
    ImageView imageView;
    Handler handler = new Handler();
    ResultReceiver receiver = new ResultReceiver(handler) {
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            Bitmap image = resultData.getParcelable("IMAGE");
            imageView.setImageBitmap(image);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        downloadButton = findViewById(R.id.downloadButton);
        downloadButton.setOnClickListener((view)-> {
            Intent intent = new Intent(MainActivityService.this, ImageDownloaderIntentService.class);
            intent.putExtra("RESULT_RECEIVER", receiver);
            intent.putExtra("LINK", "https://trendblog.net/wp-content/uploads/2013/06/android-logo.png");
            startService(intent);
        });

    }


}