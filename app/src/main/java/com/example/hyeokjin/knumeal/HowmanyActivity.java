package com.example.hyeokjin.knumeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class HowmanyActivity extends AppCompatActivity {
    String str;
    TextView textview;
    EditText editText;
    int num;

    ArrayList<Restaurant> restaurant_main = new ArrayList<Restaurant>();
    ArrayList<Restaurant> restaurant_hall = new ArrayList<Restaurant>();
    ArrayList<Restaurant> find_restaurant = new ArrayList<Restaurant>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howmany);
        editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button4);
        textview = (TextView) findViewById(R.id.textView);


        restaurant_main.add(new Restaurant("밥버거", 1, 2, 1));
        restaurant_hall.add(new Restaurant("밥버거1", 2, 3, 1));
        restaurant_hall.add(new Restaurant("한솥2", 3, 4, 2));
        restaurant_hall.add(new Restaurant("한솥3", 3, 4, 2));
        restaurant_hall.add(new Restaurant("한솥4", 3, 4, 3));
        restaurant_hall.add(new Restaurant("한솥5", 3, 4, 4));
        restaurant_hall.add(new Restaurant("한솥6", 3, 4, 5));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str = editText.getText().toString();
                num = Integer.parseInt(editText.getText().toString());
                if (str.length() == 0) {
                    textview.setText("값을 입력하시오");
                } else {
                    if (num == 1) {
                        textview.setText("혼밥");
                        for(int i=0;i<restaurant_hall.size();i++)
                        {
                            if(restaurant_hall.get(i).getMin_person()<2)
                                find_restaurant.add(restaurant_hall.get(i));
                        }

                    } else if (num == 2 || num == 3) {
                        textview.setText("2~3명 액티비티");

                        for(int i=0;i<restaurant_hall.size();i++)
                        {
                            if(restaurant_hall.get(i).getMin_person()<4)
                                find_restaurant.add(restaurant_hall.get(i));
                        }
                    } else if (num == 4 || num == 5 || num == 6) {
                        textview.setText("4~6명 액티비티");

                        for(int i=0;i<restaurant_hall.size();i++)
                        {
                            if(restaurant_hall.get(i).getMin_person()<7)
                                find_restaurant.add(restaurant_hall.get(i));
                        }

                    } else if (num >= 6) {
                        textview.setText("6명이상 액티비티");

                        for(int i=0;i<restaurant_hall.size();i++)
                        {
                            if(restaurant_hall.get(i).getMin_person()>=7)
                                find_restaurant.add(restaurant_hall.get(i));
                        }

                    } else {
                        textview.setText("양의 정수를 입력하시오");
                    }
                }

                Intent intent = new Intent(getApplicationContext(), onepeopleActivity.class);
                intent.putParcelableArrayListExtra("main_gate", find_restaurant);
                startActivity(intent);
                //test

            }

        });
    }


}
