package com.example.hyeokjin.knumeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class RandomAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_acitivity);

        final ArrayList<Restaurant> restaurants;
        Intent intent = getIntent();
        restaurants = intent.getParcelableArrayListExtra("ToRandom");

    }
}
