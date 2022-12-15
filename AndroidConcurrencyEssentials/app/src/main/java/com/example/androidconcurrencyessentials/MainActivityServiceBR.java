package com.example.androidconcurrencyessentials;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivityServiceBR extends AppCompatActivity {
    Button downloadButton;
    ImageView imageView;


    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bitmap bitmap = intent.getParcelableExtra("IMAGE");
            imageView.setImageBitmap(bitmap);
        }
    };


    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.androidconcurrencyessentials.IMAGE_DOWNLOADED");

        LocalBroadcastManager manager = LocalBroadcastManager.getInstance(this);
        manager.registerReceiver(receiver, filter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        downloadButton = findViewById(R.id.downloadButton);
        downloadButton.setOnClickListener((view)-> {
            Intent intent = new Intent(MainActivityServiceBR.this, ImageDownloaderIntentServiceBR.class);
            // intent.putExtra("LINK", "https://trendblog.net/wp-content/uploads/2013/06/android-logo.png");
            intent.putExtra("LINK", "https://www.nasa.gov/sites/default/files/thumbnails/image/potw2102a.jpg");
            startService(intent);
        });

    }


}