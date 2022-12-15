package com.example.androidconcurrencyessentials;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetworkUtil {
    public static Bitmap downloadImage(String link) {
        try {

            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            InputStream inStr = connection.getInputStream();
            Bitmap image = BitmapFactory.decodeStream(inStr);
            return image;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
