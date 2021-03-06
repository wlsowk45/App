package com.example.hyeokjin.knumeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
    ArrayList<Restaurant> onerestaurants=new ArrayList<Restaurant>();
    ArrayList<Restaurant> delivery_restaurant = new ArrayList<Restaurant>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button);
        Button button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);
        Button button4=(Button)findViewById(R.id.button5);

        restaurants.add(new Restaurant("북경반점", 35.8857360, 128.6109280, 2,"Hall_gate",4000,"053-952-4810",1));
        restaurants.add(new Restaurant("해금강", 35.8851460, 128.6121580, 2,"Hall_gate",3000,"053-941-5289",1));

        restaurants.add(new Restaurant("밥버거", 35.8855700, 128.6096760, 1,"Hall_gate",3000,"053-939-0982",0));
        restaurants.add(new Restaurant("종이밥", 35.8855620, 128.6104720, 1,"Hall_gate",3000,"053-816-5300",0));
        restaurants.add(new Restaurant("우리분식", 35.8849900, 128.6098150, 2,"Hall_gate",5000,"053-942-7877",0));
        restaurants.add(new Restaurant("동아리분식", 35.8853930, 128.6098490, 2,"Hall_gate",5000,"053-952-0376",0));
        restaurants.add(new Restaurant("맛나분식", 35.885397, 128.609850, 2,"Hall_gate",5000,"053-954-1848",0));
        restaurants.add(new Restaurant("죠스찜닭", 35.8852700, 128.6098200, 3,"Hall_gate",7000,"053-939-3433",0));
        restaurants.add(new Restaurant("통큰할매순대국밥", 35.8857820, 128.6103930, 2,"Hall_gate",6000,"053-958-5351",0));
        restaurants.add(new Restaurant("맘스터치",35.885838,128.610095,1,"Hall_gate",5500,"053-955-4242",1));
        restaurants.add(new Restaurant("GS편의점", 35.8861400, 128.6101130, 1,"Hall_gate",1100,"053-955-3852",0));
        restaurants.add(new Restaurant("다이마루", 35.8849470, 128.6100810, 2,"Hall_gate",8000,"053-939-2233",0));
        restaurants.add(new Restaurant("돈까스백작", 35.8849470, 128.6100810, 2,"Hall_gate",6000,"053-955-0601",0));
        restaurants.add(new Restaurant("피자빙고", 35.883999, 128.609, 2,"Hall_gate",7000,"053-939-8777",1));
        restaurants.add(new Restaurant("경대밥집", 35.884159, 128.609647, 2,"Hall_gate",6000,"X",0));
        restaurants.add(new Restaurant("정글로", 35.8835710, 128.6100380, 2,"Hall_gate",7000,"053-939-9245",0));
        restaurants.add(new Restaurant("세계지도", 35.8852160, 128.6119890, 1,"Hall_gate",4000,"X",0));
        restaurants.add(new Restaurant("몬나니떡볶이", 35.8856980, 128.6107540, 2,"Hall_gate",4000,"053-953-2985",0));
        restaurants.add(new Restaurant("쪽문분식", 35.8857690, 128.6102570, 2,"Hall_gate",4000,"053-943-5612",0));
        restaurants.add(new Restaurant("금계찜닭", 35.8857690, 128.6102570, 2,"Hall_gate",7000,"070-7629-0102",0));
        restaurants.add(new Restaurant("다이가쿠", 35.8851550, 128.6098550, 2,"Hall_gate",10000,"053-955-0015",0));
        restaurants.add(new Restaurant("장터국밥", 35.8857740, 128.6098750, 1,"Hall_gate",5000,"X",0));
        restaurants.add(new Restaurant("유정분식", 35.8853930, 128.6098490, 1,"Hall_gate",5000,"053-941-7273",0));
        restaurants.add(new Restaurant("또또분식", 35.8854540, 128.6100860, 2,"Hall_gate",5000,"053-942-8919",0));
        restaurants.add(new Restaurant("행컵", 35.8853450, 128.6101260, 1,"Hall_gate",4000,"053-943-1114",0));
        restaurants.add(new Restaurant("부리또", 35.8852120, 128.6100750, 1,"Hall_gate",3000,"053-214-2425",1));
        restaurants.add(new Restaurant("예전 손국수집", 35.8848200, 128.6100720, 2,"Hall_gate",7000,"053-939-0920",0));
        restaurants.add(new Restaurant("짬마담", 35.8848200, 128.6100720, 2,"Hall_gate",8000,"053-944-0534",0));
        restaurants.add(new Restaurant("닭 튀기는남자", 35.8848200, 128.6100720, 2,"Hall_gate",8000,"053-959-0039",1));
        //쪽문

        restaurants.add(new Restaurant("한솥", 35.884403, 128.613944, 1,"Main_gate",3000,"053-358-1446",0));
        restaurants.add(new Restaurant("모이다식탁", 35.8847810, 128.6136590, 1,"Main_gate",5500,"053-939-1097",0));
        restaurants.add(new Restaurant("불멸의 떡볶이", 35.8849060, 128.6139230, 1,"Main_gate",4000,"X",0));
        restaurants.add(new Restaurant("청춘라면", 35.8848000, 128.6138130, 1,"Main_gate",3000,"053-955-7868",0));
        restaurants.add(new Restaurant("김밥천국", 35.8848570, 128.6136810, 1,"Main_gate",3000,"053-944-2301",0));
        restaurants.add(new Restaurant("왕얼큰이", 2, 3, 1,"Main_gate",4000,"053-959-9889",1));
        restaurants.add(new Restaurant("경대루", 35.8851920, 128.6138910, 1,"Main_gate",4000,"053-955-0081",1));
        restaurants.add(new Restaurant("경주국밥", 2, 3, 1,"Main_gate",5500,"053-939-0769",0));
        restaurants.add(new Restaurant("땅땅치킨", 35.8844440, 128.6139200, 2,"Main_gate",9000,"053-958-6464",1));
        restaurants.add(new Restaurant("술판닭", 35.8850100, 128.6130150, 2,"Main_gate",5500,"053-959-1133",1));
        restaurants.add(new Restaurant("성화국밥", 35.8849040, 128.6126750, 1,"Main_gate",7000,"053-941-3588",0));
        restaurants.add(new Restaurant("큰손왕뼈다귀해장국", 35.8849500, 128.6132000, 1,"Main_gate",6000,"053-957-8684",0));
        restaurants.add(new Restaurant("충만치킨", 35.8848820, 128.6133530, 2,"Main_gate",8000,"053-939-4121",1));
        restaurants.add(new Restaurant("거침없이 파닭", 35.8852660, 128.6123780, 2,"Main_gate",5500,"053-952-9937",1));
        restaurants.add(new Restaurant("닥떼들", 35.885042, 128.612467, 2,"Main_gate",8000,"053-939-2151",1));
        //정문
        restaurants.add(new Restaurant("김밥파는사람들", 35.882932, 128.621543, 2,"Main_gate",13000,"053-958-9583",1));
        restaurants.add(new Restaurant("고기듬뿍대왕비빔밥", 35.895804, 128.612526, 2,"Main_gate",14000,"053-955-0678",1));
        restaurants.add(new Restaurant("숯불위 석쇠 한판", 35.885594, 128.616700, 2,"Main_gate",16000,"053-944-6555",1));
        restaurants.add(new Restaurant("닥떼들", 35.885042, 128.612467, 2,"Main_gate",8000,"053-939-2151",1));
        restaurants.add(new Restaurant("닥떼들", 35.885042, 128.612467, 2,"Main_gate",8000,"053-939-2151",1));
        restaurants.add(new Restaurant("닥떼들", 35.885042, 128.612467, 2,"Main_gate",8000,"053-939-2151",1));
        restaurants.add(new Restaurant("닥떼들", 35.885042, 128.612467, 2,"Main_gate",8000,"053-939-2151",1));
        restaurants.add(new Restaurant("닥떼들", 35.885042, 128.612467, 2,"Main_gate",8000,"053-939-2151",1));
        restaurants.add(new Restaurant("닥떼들", 35.885042, 128.612467, 2,"Main_gate",8000,"053-939-2151",1));
        restaurants.add(new Restaurant("닥떼들", 35.885042, 128.612467, 2,"Main_gate",8000,"053-939-2151",1));






        //인원수 클릭했을때
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int j=0;j<restaurants.size();j++) {
                    if (restaurants.get(j).getMin_person() == 1) {
                        onerestaurants.add(restaurants.get(j));
                    }
                }

                //main->Onepeople
                Intent intent=new Intent(MainActivity.this,Whereactivity.class);
                intent.putParcelableArrayListExtra("To where", onerestaurants);
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
                Intent intent3=new Intent(MainActivity.this,Whereactivity.class);
                intent3.putParcelableArrayListExtra("To where", restaurants);
                startActivity(intent3);
            }
        });

        //배달 클릭
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                for(int j=0;j<restaurants.size();j++) {
                    if (restaurants.get(j).getDelivery() == 1) {
                        delivery_restaurant.add(restaurants.get(j));
                    }
                }

                Intent intent4=new Intent(MainActivity.this,onepeopleActivity.class);
                intent4.putParcelableArrayListExtra("To one", delivery_restaurant);
                startActivity(intent4);
                delivery_restaurant.clear();
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