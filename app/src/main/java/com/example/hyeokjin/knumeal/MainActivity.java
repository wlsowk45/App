package com.example.hyeokjin.knumeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyApplication myApplication;

    ArrayList<Restaurant> restaurant_main = new ArrayList<Restaurant>();
    ArrayList<Restaurant> restaurant_hall = new ArrayList<Restaurant>();
    ArrayList<Restaurant> find_restaurant = new ArrayList<Restaurant>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button);
        Button button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);

        restaurant_main.add(new Restaurant("밥버거", 1, 2, 1));
        restaurant_hall.add(new Restaurant("밥버거1", 2, 3, 1));
        restaurant_hall.add(new Restaurant("한솥2", 3, 4, 2));
        restaurant_hall.add(new Restaurant("한솥3", 3, 4, 2));
        restaurant_hall.add(new Restaurant("한솥4", 3, 4, 3));
        restaurant_hall.add(new Restaurant("한솥5", 3, 4, 4));
        restaurant_hall.add(new Restaurant("한솥6", 3, 4, 5));

        //restaurant data

        //인원수 클릭했을때
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,HowmanyActivity.class);
                intent.putParcelableArrayListExtra("main_gate", restaurant_hall);
                startActivity(intent);
            }
        });
        //가격대 클릭했을때
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(MainActivity.this,HowmuchActivity.class);
                intent2.putParcelableArrayListExtra("main_gate", restaurant_hall);
                startActivity(intent2);
            }
        });
        //올랜덤 클릭했을때
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(MainActivity.this,RandomAcitivity.class);
                intent3.putParcelableArrayListExtra("main_gate", restaurant_hall);
                startActivity(intent3);
            }
        });



        /*
        ArrayList<Restaurant> restaurants_main;
        Intent i = getIntent();
        restaurants_main = i.getParcelableArrayListExtra("main_gate");

        Toast.makeText(getApplicationContext(),restaurants_main.get(0).getName(),Toast.LENGTH_LONG).show();
        */

        //test


       /*
       //permission이 허가 되었는지 확인 granted == true
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            //permission이 허가됨
            myApplication.locationPermission = true;
        }
        if(!myApplication.locationPermission){
            //여러개 넣어주면 dialog 여러개 뜸
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION},10);
        }
        */


    }
}