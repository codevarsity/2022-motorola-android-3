package com.example.fragmentessentials;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class FragmentLifecycle extends AppCompatActivity {

    Button addButton;
    Button removeButton;
    Button attachButton;
    Button detachButton;
    ColorFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_lifecycle);

        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener((view)->{
            fragment = ColorFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.mainLayout, fragment, "CF").commit();

        });

        removeButton = findViewById(R.id.removeButton);
        removeButton.setOnClickListener((view)->{
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();

        });

        attachButton = findViewById(R.id.attachButton);
        attachButton.setOnClickListener((view)->{
            getSupportFragmentManager().beginTransaction().attach(fragment).commit();
        });

        detachButton = findViewById(R.id.detachButton);
        detachButton.setOnClickListener((view)->{
            getSupportFragmentManager().beginTransaction().detach(fragment).commit();

        });
    }

}