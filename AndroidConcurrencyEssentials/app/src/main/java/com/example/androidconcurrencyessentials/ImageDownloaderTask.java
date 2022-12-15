package com.example.androidconcurrencyessentials;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ImageDownloaderTask extends AsyncTask<String, Void, Bitmap> {
    ImageView imageView;

    public ImageDownloaderTask(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    //onPost Execute is called on main thread
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    //doInBackground is called on background thread
    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap image = NetworkUtil.downloadImage(strings[0]);
        if(image != null) {
            Log.i("ImageDownloaderTask", "Image Downloaded Successfully");
        }
        return image;
    }


}
