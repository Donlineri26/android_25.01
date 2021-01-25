package com.example.house;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private View toolBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBox = findViewById(R.id.toolbox);
    }

    public void showSettings(View v){
        if (toolBox.getVisibility() == View.GONE)
            toolBox.setVisibility(View.VISIBLE);
        else
            toolBox.setVisibility(View.GONE);
    }
}