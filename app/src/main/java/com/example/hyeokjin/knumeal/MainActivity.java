package com.example.hyeokjin.knumeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button);
        Button button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);
        Button button4=(Button)findViewById(R.id.button4);

        final ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

        restaurants.add(new Restaurant("밥버거", 1, 2, 1,"Hall_gate",3000));
        restaurants.add(new Restaurant("밥버거1", 2, 3, 1,"Main_gate",3000));
        restaurants.add(new Restaurant("밥버거2", 2, 3, 1,"Main_gate",3000));
        restaurants.add(new Restaurant("한솥2", 3, 4, 2,"Main_gate",3000));
        restaurants.add(new Restaurant("한솥3", 3, 4, 2,"Main_gate",4000));
        restaurants.add(new Restaurant("한솥4", 3, 4, 3,"Main_gate",5000));
        restaurants.add(new Restaurant("한솥5", 3, 4, 4,"Main_gate",6000));
        restaurants.add(new Restaurant("한솥6", 3, 4, 5,"Main_gate",7000));
        restaurants.add(new Restaurant("맘스터치",35.885838,128.610095,1,"Hall_gate",5000));



        //인원수 클릭했을때
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //main->ToHow
                Intent intent=new Intent(MainActivity.this,HowmanyActivity.class);
                intent.putParcelableArrayListExtra("ToMany", restaurants);
                startActivity(intent);
            }
        });
        //가격대 클릭했을때
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(MainActivity.this,HowmuchActivity.class);
                intent2.putParcelableArrayListExtra("ToMuch", restaurants);
                startActivity(intent2);
            }
        });
        //올랜덤 클릭했을때
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(MainActivity.this,onepeopleActivity.class);
                intent3.putParcelableArrayListExtra("To one", restaurants);
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