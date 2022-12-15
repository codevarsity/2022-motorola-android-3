package com.example.androidconcurrencyessentials;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WorkerThread extends Thread {

    Handler handler ;
    Handler uiHandler;

    public WorkerThread(Handler uiHandler) {
        this.uiHandler = uiHandler;
    }

    @Override
    public void run() {
        Looper.prepare();
        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                Bundle bundle = msg.getData();
                String link = bundle.getString("LINK");
                Bitmap image = NetworkUtil.downloadImage(link);
                if(image != null) {
                    Log.i("WorkerThread", "Image Downloaded Success");

                    Message uiMsg = uiHandler.obtainMessage();
                    Bundle imageBundle = new Bundle();
                    imageBundle.putParcelable("IMAGE", image);
                    uiMsg.setData(imageBundle);
                    uiHandler.sendMessage(uiMsg);


                }
            }
        };
        Looper.loop();
    }


}
