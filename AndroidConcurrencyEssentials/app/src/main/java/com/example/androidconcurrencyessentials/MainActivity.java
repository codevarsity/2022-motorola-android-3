package com.example.androidconcurrencyessentials;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    Button downloadButton;
    ImageView imageView;
    Handler handler;
    WorkerThread workerThread;
    ImageDownloaderThread downloaderThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloaderThread = new ImageDownloaderThread("Image Downloader");
        downloaderThread.start();

        handler = new Handler(getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                Bundle bundle = msg.getData();
                Bitmap image = bundle.getParcelable("IMAGE");
                imageView.setImageBitmap(image);
            }
        };
        workerThread = new WorkerThread(handler);
        workerThread.start();
//        handler = new Handler(getMainLooper()) {
//            @Override
//            public void handleMessage(@NonNull Message msg) {
//                super.handleMessage(msg);
//                Bundle bundle = msg.getData();
//                Bitmap image = bundle.getParcelable("IMAGE");
//                imageView.setImageBitmap(image);
//            }
//        };

        imageView = findViewById(R.id.imageView);
        downloadButton = findViewById(R.id.downloadButton);
        downloadButton.setOnClickListener((view)-> {
            Message msg = handler.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putString("LINK", "https://trendblog.net/wp-content/uploads/2013/06/android-logo.png");
            msg.setData(bundle);
            workerThread.handler.sendMessage(msg);
//            Thread th = new Thread(()->{
//                Bitmap image = downloadImage("https://trendblog.net/wp-content/uploads/2013/06/android-logo.png");
//                if(image != null) {
//                    Log.i("MainActivity", "Image downloaded successfully");
//                    Bundle imageBundle = new Bundle();
//                    imageBundle.putParcelable("IMAGE", image);
//                    Message msg = Message.obtain();
//                    msg.setData(imageBundle);
//                    handler.sendMessage(msg);

            //Task message
            //                   handler.post(()->{
            //                       imageView.setImageBitmap(image);
            //                   });
            //               }
//
//            });
//            th.start();

        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        downloaderThread.quitSafely();
    }
}