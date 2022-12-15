package com.example.androidconcurrencyessentials;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.util.Log;

import androidx.annotation.Nullable;

public class ImageDownloaderService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("ImageDownloaderService", "ImageDownloaderService Creates" );
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String link = intent.getStringExtra("LINK");
        ResultReceiver receiver = intent.getParcelableExtra("RESULT_RECEIVER");

        Thread th = new Thread(()->{
            Bitmap image = NetworkUtil.downloadImage(link);
            if(image != null) {
                Log.i("ImageDownloaderService", "Image Downloaded Successfully");
                Bundle bundle = new Bundle();
                bundle.putParcelable("IMAGE", image);
                receiver.send(101, bundle);
            }

        });
        th.start();
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
