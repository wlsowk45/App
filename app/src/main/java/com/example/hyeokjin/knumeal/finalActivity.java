package com.example.hyeokjin.knumeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;

public class finalActivity extends AppCompatActivity {

    ArrayList<Restaurant> final_restaurant = new ArrayList<Restaurant>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);


        Intent intent = getIntent();
        final_restaurant = intent.getParcelableArrayListExtra("To final");

        String str = "체크된 restaurant\n";

        for(int i=0;i<final_restaurant.size();i++){
            if(final_restaurant.get(i).isChecked()) {
                str = str + final_restaurant.get(i).getName() + "\n";
            }
        }

        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();

    }

    /*
    @Override
    public void onResume(){
        super.onResume();
        // put your code here...
        Intent intent = getIntent();
        final_restaurant = intent.getParcelableArrayListExtra("To final");

        for(int i=0;i<final_restaurant.size();i++){
            if(final_restaurant.get(i).isChecked()) {
                Toast.makeText(getApplicationContext(), "체크된 식당" + final_restaurant.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "체크XXXX 식당" + final_restaurant.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        }

    }
    */
}
