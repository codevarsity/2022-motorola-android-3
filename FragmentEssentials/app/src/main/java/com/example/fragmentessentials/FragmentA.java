package com.example.fragmentessentials;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment implements IReceiveData {

    Button getDataButton;
    TextView dataTextView;
    String data = null;

    public FragmentA() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (data != null) {
            dataTextView.setText(data);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.fragment_a, container, false);
        getDataButton = mainView.findViewById(R.id.getDataButton);
        getDataButton.setOnClickListener((view)->{
            FragmentB fb = FragmentB.newInstance();
           fb.setDataReceiver(this);
            getParentFragmentManager()
                    .beginTransaction()
                    .remove(this)
                    .add(R.id.mainLayout, fb, "FB")
                    .addToBackStack("FA=>FB")
                    .commit();
        });
        dataTextView = mainView.findViewById(R.id.dataTextView);

        return mainView;
    }


    @Override
    public void receive(String r) {
        this.data = r;
    }
}
