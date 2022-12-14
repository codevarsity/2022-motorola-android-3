package com.example.fragmentessentials;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


interface IReceiveData {
    void receive(String r);
}

public class FragmentB extends Fragment {

    EditText dataEditText;
    Button cancelButton;
    Button doneButton;
    IReceiveData receiver;

    public FragmentB() {

    }

    public void setDataReceiver(IReceiveData r) {
        receiver = r;
    }

    public static FragmentB newInstance() {
        FragmentB fb = new FragmentB();
        return fb;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.fragment_b, container, false);

        dataEditText = mainView.findViewById(R.id.dataEditText);
        doneButton = mainView.findViewById(R.id.doneButton);
        doneButton.setOnClickListener((view)->{
            String data = dataEditText.getText().toString();
            if(receiver != null) {
                receiver.receive(data);
            }
            getParentFragmentManager().popBackStack();

        });
        cancelButton = mainView.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener((view)->{
            getParentFragmentManager().popBackStack();
        });
        return mainView;
    }
}
