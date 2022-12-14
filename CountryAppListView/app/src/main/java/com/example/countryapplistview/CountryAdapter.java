package com.example.countryapplistview;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintSet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CountryAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> countries;

    public CountryAdapter(Context context, ArrayList<String> countries) {
        this.context = context;
        this.countries = countries;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(ImageView imageView, TextView textView) {
            this.imageView = imageView;
            this.textView = textView;
        }
    }

    @Override
    public int getCount() {
        Log.i("CountryAdapter", "getCount()" );
        return countries.size();
    }

    @Override
    public Object getItem(int i) {

        return countries.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View rowView = null;
        if(view == null) {
            Log.i("CountryAdapter", "getView(" + i + ")" );
            rowView = inflater.inflate(R.layout.country_row, null);
            TextView countryNameTextView = rowView.findViewById(R.id.countryNameTextView);
            ImageView imageView = rowView.findViewById(R.id.flagImageView);
            ViewHolder holder = new ViewHolder(imageView, countryNameTextView);
            rowView.setTag(holder);
        } else {
            Log.i("CountryAdapter", "Recycling (" + i + ")" );
            rowView = view;
        }

        String countryName = countries.get(i);
        ViewHolder vh = (ViewHolder) rowView.getTag();

        vh.textView.setText(countryName);

        Bitmap image = flag(countryName);
        if( image != null) {
            vh.imageView.setImageBitmap(image);
        }
        return rowView;
    }

    Bitmap flag(String countryName) {
        String flagFileName = "flags-32/" + countryName + ".png";
        AssetManager manager = context.getAssets();
        try {
            InputStream inputStream = manager.open(flagFileName);
            Bitmap image = BitmapFactory.decodeStream(inputStream);
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
