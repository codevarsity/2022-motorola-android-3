package com.example.countryapprecyclerview;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

class CountriesViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView;

    public CountriesViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.flagImageView);
        textView = itemView.findViewById(R.id.countryNameTextView);
    }
}

public class CountriesAdapter extends RecyclerView.Adapter<CountriesViewHolder>{

    Context context;
    ArrayList<String> countries;

    public CountriesAdapter(Context context, ArrayList<String> countries) {
        this.context = context;
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View rowView = LayoutInflater.from(context).inflate(R.layout.country_row, null);
        CountriesViewHolder vh = new CountriesViewHolder(rowView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesViewHolder holder, int position) {
        String countryName = countries.get(position);
        holder.textView.setText(countryName);
        Bitmap image = flag(countryName);
        if( image != null) {
            holder.imageView.setImageBitmap(image);
        }

    }

    @Override
    public int getItemCount() {
        return countries.size();
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
