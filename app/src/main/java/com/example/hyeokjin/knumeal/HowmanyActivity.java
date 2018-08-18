package com.example.hyeokjin.knumeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HowmanyActivity extends AppCompatActivity {
    String str;
    TextView textview;
    EditText editText;
    int num;

    ArrayList<Restaurant> find_restaurant = new ArrayList<Restaurant>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howmany);
        editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button4);
        textview = (TextView) findViewById(R.id.textView);


        final ArrayList<Restaurant> restaurants;
        Intent intent = getIntent();
        restaurants = intent.getParcelableArrayListExtra("ToMany");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str = editText.getText().toString();

                if(str.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"인원수를 입력하세요",Toast.LENGTH_SHORT).show();
                }
                else {

                    num = Integer.parseInt(editText.getText().toString());


                    if (num == 1) {
                        textview.setText("혼밥");
                        for (int i = 0; i < restaurants.size(); i++) {
                            if (restaurants.get(i).getMin_person() < 2)
                                find_restaurant.add(restaurants.get(i));
                        }

                    } else if (num == 2 || num == 3) {
                        textview.setText("2~3명 액티비티");

                        for (int i = 0; i < restaurants.size(); i++) {
                            if (restaurants.get(i).getMin_person() >= 2 && restaurants.get(i).getMin_person() < 4)
                                find_restaurant.add(restaurants.get(i));
                        }
                    } else if (num == 4 || num == 5 || num == 6) {
                        textview.setText("4~6명 액티비티");

                        for (int i = 0; i < restaurants.size(); i++) {
                            if (restaurants.get(i).getMin_person() >= 4 && restaurants.get(i).getMin_person() < 7)
                                find_restaurant.add(restaurants.get(i));
                        }
                    } else if (num >= 6) {
                        textview.setText("6명이상 액티비티");

                        for (int i = 0; i < restaurants.size(); i++) {
                            if (restaurants.get(i).getMin_person() >= 7)
                                find_restaurant.add(restaurants.get(i));
                        }
                    } else {
                        textview.setText("양의 정수를 입력하시오");
                    }


                    //HowMany -> onepeople
                    Intent intent = new Intent(HowmanyActivity.this, onepeopleActivity.class);
                    intent.putParcelableArrayListExtra("To one", find_restaurant);
                    startActivity(intent);
                    find_restaurant.clear();

                }

                //test

            }

        });
    }


}
