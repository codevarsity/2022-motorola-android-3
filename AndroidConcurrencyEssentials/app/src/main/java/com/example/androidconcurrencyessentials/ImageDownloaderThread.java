package com.example.androidconcurrencyessentials;

import android.os.Handler;
import android.os.HandlerThread;



public class ImageDownloaderThread extends HandlerThread {
    Handler handler;
    public ImageDownloaderThread(String name) {
        super(name);
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();

        handler = new Handler(getLooper());
    }
}
