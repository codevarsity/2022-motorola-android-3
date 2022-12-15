package com.example.boundserviceexample;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.IBinder;
import android.os.RemoteException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BoundImageDownloaderService extends Service {

    public class BoundImageDownloaderServiceImpl extends IImageDownloader.Stub {

        @Override
        public String downloadImage(String link) throws RemoteException {

            File externalStorage = Environment.getExternalStorageDirectory();
            File imageFile = new File(externalStorage, "image.jpg");

            String path = imageFile.getPath().toString();
            Thread thread = new Thread(()->{
                Bitmap image = NetworkUtil.downloadImage(link);
                if(image != null) {
                    try {
                        FileOutputStream out = new FileOutputStream(imageFile);
                        image.compress(Bitmap.CompressFormat.JPEG, 90, out);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            });
            return path;
        }
    }

    public BoundImageDownloaderService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

       return new BoundImageDownloaderServiceImpl();
    }
}