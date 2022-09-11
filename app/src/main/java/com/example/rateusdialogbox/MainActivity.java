package com.example.rateusdialogbox;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Show rating dialog
        RateusDialog rateusDialog = new RateusDialog(MainActivity.this);
        rateusDialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        rateusDialog.setCancelable(false);
        rateusDialog.show();
    }
}