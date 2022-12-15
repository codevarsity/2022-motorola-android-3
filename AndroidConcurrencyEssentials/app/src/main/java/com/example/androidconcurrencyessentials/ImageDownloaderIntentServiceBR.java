package com.example.androidconcurrencyessentials;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.androidconcurrencyessentials.NetworkUtil;

public class ImageDownloaderIntentServiceBR extends IntentService {


    public ImageDownloaderIntentServiceBR() {
        super("ImageDownloaderIntentServiceBR");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i("ImageDownloaderIntentServiceBR", "Service created");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("ImageDownloaderIntentServiceBR", "Service Running");
        String link = intent.getStringExtra("LINK");

        Bitmap image = NetworkUtil.downloadImage(link);
        if(image != null) {
            Log.i("ImageDownloaderIntentServiceBR", "Image Downloaded Successfully");
            Intent brIntent = new Intent("com.example.androidconcurrencyessentials.IMAGE_DOWNLOADED");
            brIntent.putExtra("IMAGE", image);
            //sendBroadcast(brIntent);
            LocalBroadcastManager.getInstance(this).sendBroadcast(brIntent);

        }
    }

}