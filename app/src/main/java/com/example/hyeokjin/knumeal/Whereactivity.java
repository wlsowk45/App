package com.example.hyeokjin.knumeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Whereactivity extends AppCompatActivity {

    ArrayList<Restaurant> where_restaurant = new ArrayList<Restaurant>();
    ArrayList<Restaurant>  main_restaurant = new ArrayList<Restaurant>();
    ArrayList<Restaurant> hall_restaurant = new ArrayList<Restaurant>();
    ArrayList<Restaurant> mainhall_restaurant = new ArrayList<Restaurant>();
    ArrayList<Restaurant> north_restaurant = new ArrayList<Restaurant>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whereactivity);



        Intent i = getIntent();
        where_restaurant = i.getParcelableArrayListExtra("To where");

        for(int j=0;j<where_restaurant.size();j++){
            if(where_restaurant.get(j).getPosition()=="Main_gate"){
                main_restaurant.add(where_restaurant.get(j));
            }
            if(where_restaurant.get(j).getPosition()=="Hall_gate"){
                hall_restaurant.add(where_restaurant.get(j));
            }
            if(where_restaurant.get(j).getPosition()=="Main_gate"||where_restaurant.get(j).getPosition()=="Hall_gate"){
                mainhall_restaurant.add(where_restaurant.get(j));
            }
            if(where_restaurant.get(j).getPosition()=="North_gate") {
                north_restaurant.add(where_restaurant.get(j));
            }


        }

        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Whereactivity.this, onepeopleActivity.class);
                intent2.putParcelableArrayListExtra("To one", where_restaurant);
                startActivity(intent2);
            }
        });  //상관없음 클릭시

        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Whereactivity.this, onepeopleActivity.class);
                intent3.putParcelableArrayListExtra("To one", main_restaurant);
                startActivity(intent3);
            }
        }); //정문 클릭시

        Button button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(Whereactivity.this, onepeopleActivity.class);
                intent4.putParcelableArrayListExtra("To one", hall_restaurant);
                startActivity(intent4);
            }
        }); //쪽문 클릭시

        Button button4=(Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(Whereactivity.this, onepeopleActivity.class);
                intent5.putParcelableArrayListExtra("To one", mainhall_restaurant);
                startActivity(intent5);
            }
        });  //정문 AND 쪽문 클릭시

        Button button5=(Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(Whereactivity.this, onepeopleActivity.class);
                intent6.putParcelableArrayListExtra("To one", north_restaurant);
                startActivity(intent6);
            }
        });  //북문 클릭시




    }
}
