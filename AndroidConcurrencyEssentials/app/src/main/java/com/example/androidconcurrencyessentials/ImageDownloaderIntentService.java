package com.example.androidconcurrencyessentials;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

public class ImageDownloaderIntentService extends IntentService {


    public ImageDownloaderIntentService() {
        super("ImageDownloaderIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i("ImageDownloaderIntentService", "Service created");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("ImageDownloaderIntentService", "Service Running");
        String link = intent.getStringExtra("LINK");
        ResultReceiver receiver = intent.getParcelableExtra("RESULT_RECEIVER");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Bitmap image = NetworkUtil.downloadImage(link);
        if(image != null) {
            Log.i("ImageDownloaderService", "Image Downloaded Successfully");
            Bundle bundle = new Bundle();
            bundle.putParcelable("IMAGE", image);
            receiver.send(101, bundle);
        }
    }

}