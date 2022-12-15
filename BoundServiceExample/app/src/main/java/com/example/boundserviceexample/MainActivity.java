package com.example.boundserviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Button;

import kotlinx.coroutines.MainCoroutineDispatcher;

public class MainActivity extends AppCompatActivity {


    Button connectButton;
    Button downloadButton;
    IImageDownloader downloader;

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            downloader = IImageDownloader.Stub.asInterface(iBinder);
            if(downloader != null) {
                Log.i("MainActivity", "Connected to Remote Service");
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            downloader = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectButton = findViewById(R.id.connectButton);
        connectButton.setOnClickListener((view)->{

            Intent intent = new Intent(MainActivity.this, BoundImageDownloaderService.class);

            bindService(intent, connection, BIND_AUTO_CREATE);
        });
        downloadButton = findViewById(R.id.downloadButton);
        downloadButton.setOnClickListener((view)->{
            try {
                String link = downloader.downloadImage("https://www.nasa.gov/sites/default/files/thumbnails/image/potw2102a.jpg");

                if (link != null) {
                    Log.i("MainActivity", link);
                    Log.i("MainActivity", "Image Downloaded Successfully");
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });

    }
}