package com.example.fragmentessentials;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ColorFragment extends Fragment {


    public ColorFragment() {
        // Required empty public constructor
    }

    public static ColorFragment newInstance() {
        ColorFragment fragment = new ColorFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("ColorFragment", "onCreate()");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i("ColorFragment", "onAttach()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("ColorFragment", "onCreateView()");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.i("ColorFragment", "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("ColorFragment", "onResume");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("ColorFragment", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("ColorFragment", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("ColorFragment", "onDetach");
    }
}