package com.example.androidconcurrencyessentials;

import android.graphics.Bitmap;
import android.media.AsyncPlayer;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityAsync extends AppCompatActivity {
    Button downloadButton;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        downloadButton = findViewById(R.id.downloadButton);
        downloadButton.setOnClickListener((view)-> {
            ImageDownloaderTask task = new ImageDownloaderTask(imageView);
            //task.execute("https://trendblog.net/wp-content/uploads/2013/06/android-logo.png");
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                            "https://trendblog.net/wp-content/uploads/2013/06/android-logo.png");

        });

    }


}