package com.example.hyeokjin.knumeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;

public class finalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        String str="";

        boolean from_one=false;
        boolean from_price=false;
        boolean from_random=false;

        final ArrayList<Restaurant> final_restaurant;

        Intent intent = getIntent();
        final_restaurant = intent.getParcelableArrayListExtra("To final");

        for(int i=0;i<final_restaurant.size();i++)
        {
            str = str + final_restaurant.get(i).isChecked() + "\n";
        }

        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();


    }
}
