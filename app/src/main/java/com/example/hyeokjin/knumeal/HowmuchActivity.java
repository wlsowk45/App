package com.example.hyeokjin.knumeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class HowmuchActivity extends AppCompatActivity {
    String str;
    TextView textview;
    EditText editText;
    int num;

    ArrayList<Restaurant> find_restaurant = new ArrayList<Restaurant>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howmuch);
        editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button4);
        textview=(TextView)findViewById(R.id.textView);



        final ArrayList<Restaurant> restaurants;
        Intent intent = getIntent();
        restaurants = intent.getParcelableArrayListExtra("ToMuch");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str = editText.getText().toString();
                num = Integer.parseInt(editText.getText().toString());

                if (str.length() == 0) {
                    textview.setText("값을 입력하시오");
                } else {
                    if (num <2500) {
                        for(int i=0;i<restaurants.size();i++)
                        {
                            if(restaurants.get(i).getPrice()<2500)
                                find_restaurant.add(restaurants.get(i));
                        }

                    } else if (num>=2500&&num<4000) {

                        for(int i=0;i<restaurants.size();i++)
                        {
                            if(restaurants.get(i).getPrice()>=2500 && restaurants.get(i).getPrice()<4000)
                                find_restaurant.add(restaurants.get(i));
                        }
                    } else if (num>=4000&&num<5000) {
                        for(int i=0;i<restaurants.size();i++)
                        {
                            if(restaurants.get(i).getPrice()>=4000&& restaurants.get(i).getPrice()<5000)
                                find_restaurant.add(restaurants.get(i));
                        }
                    } else if (num >=5000&&num<6000) {

                        for(int i=0;i<restaurants.size();i++)
                        {
                            if(restaurants.get(i).getPrice()>=5000&&restaurants.get(i).getPrice()<6000)
                                find_restaurant.add(restaurants.get(i));
                        }




                    }

                    else if (num >6000) {

                        for (int i = 0; i < restaurants.size(); i++) {
                            if (restaurants.get(i).getPrice() > 6000)
                                find_restaurant.add(restaurants.get(i));
                        }
                    }
                    else {
                        textview.setText("양의 정수를 입력하시오");
                    }
                }

                //HowMuch -> onepeople
                Intent intent=new Intent(HowmuchActivity.this,onepeopleActivity.class);
                intent.putParcelableArrayListExtra("ToOne", find_restaurant);
                startActivity(intent);
                find_restaurant.clear();



                //test

            }

        });
    }


}
