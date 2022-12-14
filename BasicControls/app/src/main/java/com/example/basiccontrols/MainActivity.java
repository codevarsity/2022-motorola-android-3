package com.example.basiccontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Button button;
    Switch switchControl;
    CheckBox checkBox;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener((view)->{
            Log.i("MainActivity", "Button Tapped");
        });

        switchControl = findViewById(R.id.switch1);
        switchControl.setOnCheckedChangeListener((compoundButton, isOn)->{
            if(isOn) {
                Log.i("MainActivity", "Switch is On");
            } else {
                Log.i("MainActivity", "Switch is Off");
            }
        });

        checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener((compoundButton, b)->{

        });

        group = findViewById(R.id.group);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if( i == R.id.radioButton2) {
                    
                }
            }
        });

    }
}