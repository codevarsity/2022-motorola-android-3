package com.example.fragmentessentials;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FirstFragment extends Fragment {

    Button switchToSecondButton;

    FirstFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_first, container, false);
        switchToSecondButton = fragmentView.findViewById(R.id.button);
        switchToSecondButton.setOnClickListener((view)->{
            SecondFragment sf = new SecondFragment();
            FragmentManager manager = getParentFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(this);
            transaction.add(R.id.mainLayout, sf, "SF");
            transaction.commit();

        });
        return fragmentView;
    }
}
