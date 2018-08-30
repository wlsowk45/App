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
        restaurants.add(new Restaurant("종이밥", 2, 3, 1,"Hall_gate",3000));
        restaurants.add(new Restaurant("우리분식", 3, 4, 2,"Hall_gate",5000));
        restaurants.add(new Restaurant("동아리분식", 3, 4, 2,"Hall_gate",5000));
        restaurants.add(new Restaurant("맛나분식", 35.885397, 128.609850, 2,"Hall_gate",5000));
        restaurants.add(new Restaurant("죠스찜닭", 35.885287, 128.609281, 3,"Hall_gate",7000));
        restaurants.add(new Restaurant("순대국밥", 3, 4, 2,"Hall_gate",6000));
        restaurants.add(new Restaurant("맘스터치",35.885838,128.610095,1,"Hall_gate",5500));
        restaurants.add(new Restaurant("GS편의점", 3, 4, 1,"Hall_gate",1100));
        restaurants.add(new Restaurant("다이마루", 3, 4, 2,"Hall_gate",8000));
        restaurants.add(new Restaurant("돈까스백작", 3, 4, 2,"Hall_gate",6000));
        restaurants.add(new Restaurant("피자빙고", 35.883999, 128.609, 2,"Hall_gate",7000));
        restaurants.add(new Restaurant("경대밥집", 35.884159, 128.609647, 2,"Hall_gate",6000));
        restaurants.add(new Restaurant("정글로", 3, 4, 2,"Hall_gate",7000));
        restaurants.add(new Restaurant("세계지도", 3, 4, 1,"Hall_gate",4000));
        restaurants.add(new Restaurant("몬나니떡볶이", 3, 4, 2,"Hall_gate",4000));
        restaurants.add(new Restaurant("북경반점", 3, 4, 2,"Hall_gate",4000));
        restaurants.add(new Restaurant("해금강", 3, 4, 2,"Hall_gate",3000));
        restaurants.add(new Restaurant("쪽문분식", 3, 4, 2,"Hall_gate",4000));
        restaurants.add(new Restaurant("뼈찜", 3, 4, 1,"Hall_gate",6000));
        restaurants.add(new Restaurant("한솥", 2, 3, 1,"Main_gate",3000));
        restaurants.add(new Restaurant("모이다식탁", 2, 3, 1,"Main_gate",5500));
        restaurants.add(new Restaurant("불멸의 떡볶이", 2, 3, 1,"Main_gate",4000));
        restaurants.add(new Restaurant("청춘라면", 2, 3, 1,"Main_gate",3000));
        restaurants.add(new Restaurant("김밥천국", 2, 3, 1,"Main_gate",3000));
        restaurants.add(new Restaurant("왕얼큰이", 2, 3, 1,"Main_gate",4000));
        restaurants.add(new Restaurant("경대루", 2, 3, 1,"Main_gate",4000));
        restaurants.add(new Restaurant("경주국밥", 2, 3, 1,"Main_gate",5500));
        restaurants.add(new Restaurant("땅땅치킨", 2, 3, 1,"Main_gate",9000));
        restaurants.add(new Restaurant("미쳐버린 파닭", 2, 3, 1,"Main_gate",5500));









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

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent4=new Intent (MainActivity.this,MapsActivity.class);
                intent4.putParcelableArrayListExtra("ToMap", restaurants);
                startActivity(intent4);
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