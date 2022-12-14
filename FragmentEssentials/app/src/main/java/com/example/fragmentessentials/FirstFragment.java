package com.example.fragmentessentials;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FirstFragment extends Fragment {

    Button switchToSecondButton;
    EditText messageEditText;

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
        messageEditText = fragmentView.findViewById(R.id.messageEditText);
        switchToSecondButton = fragmentView.findViewById(R.id.button);
        switchToSecondButton.setOnClickListener((view)->{
            String message = messageEditText.getText().toString();
            Fragment sf = SecondFragment.newInstance(message);
            getParentFragmentManager()
                    .beginTransaction()
                    .remove(this)
                    .add(R.id.mainLayout, sf, "SF")
                    .addToBackStack("FF->SF")
                    .commit();

        });
        return fragmentView;
    }
}
