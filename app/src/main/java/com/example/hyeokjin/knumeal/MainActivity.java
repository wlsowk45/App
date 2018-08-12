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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button);

        //restaurant data
        restaurant_main.add(new Restaurant("밥버거",1,2,1));
        restaurant_hall.add(new Restaurant("밥버거1",2,3,1));
        restaurant_hall.add(new Restaurant("한솥",3,4,5));

        //인원수 클릭했을때
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,HowmanyActivity.class);
                startActivity(intent);
            }
        });

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