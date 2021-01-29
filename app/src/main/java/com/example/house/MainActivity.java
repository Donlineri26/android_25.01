package com.example.house;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private View toolBox;
    private View second;
    private View third;
    private View fourth;
    private View fifth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBox = findViewById(R.id.toolbox);
        ImageView windowOnRoof = findViewById(R.id.roof_window);
        CheckBox statusWindowOnRoof = findViewById(R.id.roof_window_checkbox);
        statusWindowOnRoof.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                windowOnRoof.setVisibility(isChecked ? View.VISIBLE: View.GONE);
            }
        });
        ImageView door = findViewById(R.id.door);
        RadioGroup door_settings = findViewById(R.id.radio_group_door_orientation);
        door_settings.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_door_left)
                    door.setImageResource(R.drawable.reverse_door);
                else
                    door.setImageResource(R.drawable.door);
            }
        });
        EditText countStage = findViewById(R.id.stage_num);
        second = findViewById(R.id.second_stage);
        third = findViewById(R.id.third_stage);
        fourth = findViewById(R.id.fourth_stage);
        fifth = findViewById(R.id.fifth_stage);
        countStage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() != 0 && isDigit(s.toString())) {
                    int numStage = Integer.parseInt(s.toString());
                    switch (numStage) {
                        case 1:
                            showStage(View.GONE, View.GONE,
                                      View.GONE, View.GONE);
                            break;
                        case 2:
                            showStage(View.VISIBLE, View.GONE,
                                      View.GONE, View.GONE);
                            break;
                        case 3:
                            showStage(View.VISIBLE, View.VISIBLE,
                                      View.GONE, View.GONE);
                            break;
                        case 4:
                            showStage(View.VISIBLE, View.VISIBLE,
                                      View.VISIBLE, View.GONE);
                            break;
                        case 5:
                            showStage(View.VISIBLE, View.VISIBLE,
                                      View.VISIBLE, View.VISIBLE);
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }

    public void showStage(int second_status, int third_status,
                          int fourth_status, int fifth_status){
        second.setVisibility(second_status);
        third.setVisibility(third_status);
        fourth.setVisibility(fourth_status);
        fifth.setVisibility(fifth_status);
    }

    public boolean isDigit(String str){
        for(int i=0;i<str.length();i++)
            if (str.charAt(i)<48 || str.charAt(i)>57) return false;
        return true;
    }

    public void showSettings(View v){
        if (toolBox.getVisibility() == View.GONE)
            toolBox.setVisibility(View.VISIBLE);
        else
            toolBox.setVisibility(View.GONE);
    }
}