package com.example.babypredictor;

import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.CheckBox;

public class MotherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mother);
        /**Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });**/
        configureNextButton();
    }
    private void configureNextButton() {
        Button nextButton = (Button) findViewById(R.id.NextM);
        final TextView widowB = (TextView) findViewById(R.id.WidowB);
        final TextView dimplesB = (TextView) findViewById(R.id.DimplesB);
        final TextView earlobesB = (TextView) findViewById(R.id.EarlobesB);
        final TextView frecklesB = (TextView) findViewById(R.id.FrecklesB);
        final TextView brownB = (TextView) findViewById(R.id.BrownB);
        final TextView greenB = (TextView) findViewById(R.id.GreenB);
        final TextView blueB = (TextView) findViewById(R.id.BlueB);
        final Switch widowF = (Switch) findViewById(R.id.WidowF);
        final Switch dimplesF = (Switch) findViewById(R.id.DimplesF);
        final Switch earlobesF = (Switch) findViewById(R.id.EarlobesF);
        final Switch frecklesF = (Switch) findViewById(R.id.FrecklesF);
        final CheckBox brownF = (CheckBox) findViewById(R.id.BrownF);
        final CheckBox greenF = (CheckBox) findViewById(R.id.GreenF);
        //final CheckBox blueF = (CheckBox) findViewById(R.id.BlueF);
        final Switch widowM = (Switch) findViewById(R.id.WidowM);
        final Switch dimplesM = (Switch) findViewById(R.id.DimplesM);
        final Switch earlobesM = (Switch) findViewById(R.id.EarlobesM);
        final Switch frecklesM = (Switch) findViewById(R.id.FrecklesM);
        final CheckBox brownM = (CheckBox) findViewById(R.id.BrownM);
        final CheckBox greenM = (CheckBox) findViewById(R.id.GreenM);
        //final CheckBox blueM = (CheckBox) findViewById(R.id.BlueM);
        //Button nextButton = (Button) findViewById(R.id.NextM);
        String fatherEyeColor = "";
        String motherEyeColor = "";
        if (brownF.isChecked()) {
            fatherEyeColor = "brown";
        } else if (greenF.isChecked()) {
            fatherEyeColor = "green";
        } else {
            fatherEyeColor = "blue";
        }
        if (brownM.isChecked()) {
            motherEyeColor = "brown";
        } else if (greenM.isChecked()) {
            motherEyeColor = "green";
        } else {
            motherEyeColor = "blue";
        }
        final String[] eyeColor = eyeColor(fatherEyeColor, motherEyeColor);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MotherActivity.this, BabyActivity.class));
                widowB.setText("Widow's Peak: " + percentage(widowF.isChecked(), widowM.isChecked()));
                dimplesB.setText("Dimples: " + percentage(dimplesF.isChecked(), dimplesM.isChecked()));
                earlobesB.setText("Free earlobes: " + percentage(earlobesF.isChecked(), earlobesM.isChecked()));
                frecklesB.setText("Freckles: " + percentage(frecklesF.isChecked(), frecklesM.isChecked()));
                brownB.setText("Brown: " + eyeColor[0]);
                greenB.setText("Green: " + eyeColor[1]);
                blueB.setText("Blue: " + eyeColor[2]);
            }
        });
    }
    private String percentage(final boolean fatherDominant, final boolean motherDominant) {
        if (fatherDominant == true && motherDominant == true) {
            return "93.75%";
        }
        if (fatherDominant == false && motherDominant == false) {
            return "0.00%";
        }
        return "75.00%";
    }
    private String[] eyeColor(String fatherColor, String motherColor) {
        String[] eyeColor = new String[3];
        if (fatherColor.equals("brown") && motherColor.equals("brown")) {
            eyeColor[0] = "93.75%";
            eyeColor[1] = "4.6875%";
            eyeColor[2] = "1.5625%";
        } else if (fatherColor.equals("brown") || motherColor.equals("brown")) {
            eyeColor[0] = "75.00%";
            if (fatherColor.equals("green") || motherColor.equals("green")) {
                eyeColor[1] = "21.875%";
                eyeColor[2] = "3.125%";
            } else {
                eyeColor[1] = "12.50%";
                eyeColor[2] = "12.50%";
            }
        } else {
            eyeColor[0] = "0.00%";
            if (fatherColor.equals("green") && motherColor.equals("green")) {
                eyeColor[1] = "93.75%";
                eyeColor[2] = "6.25%";
            } else if (fatherColor.equals("blue") && motherColor.equals("blue")) {
                eyeColor[1] = "0.00%";
                eyeColor[2] = "100.00%";
            } else {
                eyeColor[1] = "75.00%";
                eyeColor[2] = "25.00%";
            }
        }
        return eyeColor;
    }
}
