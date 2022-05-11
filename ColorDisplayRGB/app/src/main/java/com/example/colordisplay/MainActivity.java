package com.example.colordisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity {
    private int red = 200;
    private int green = 150;
    private int blue = 75;
    View colorDisplay = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorDisplay = findViewById(R.id.colorDisplay);
        colorDisplay.setBackgroundColor(Color.argb(255, red, green, blue));

        SeekBar seekBarRed = (SeekBar) findViewById(R.id.seekBarRed);

        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                handleColorChange(progress, green, blue);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });

        SeekBar seekBarGreen = findViewById(R.id.seekBarGreen);

        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                handleColorChange(red, progress, blue);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });

        SeekBar seekBarBlue = findViewById(R.id.seekBarBlue);

        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                handleColorChange(red, green, progress);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });
    }

    private void handleColorChange(int r, int g, int b) {
        red = r;
        green = g;
        blue = b;
        colorDisplay.setBackgroundColor(Color.argb(255, red, green, blue));
    }

}