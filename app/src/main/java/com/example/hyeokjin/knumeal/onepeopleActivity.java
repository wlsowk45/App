package com.example.hyeokjin.knumeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class onepeopleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onepeople);


        ArrayList<Restaurant> found_restaurant;
        Intent i = getIntent();
        found_restaurant = i.getParcelableArrayListExtra("ToOne");


        TextView textView1=(TextView)findViewById(R.id.textView);
        TextView textView2=(TextView)findViewById(R.id.textView2);
        TextView textView3=(TextView)findViewById(R.id.textView3);

        textView1.setText(found_restaurant.get(0).getName());
        textView2.setText(found_restaurant.get(1).getName());
        textView3.setText(found_restaurant.get(2).getName());


    }
}
