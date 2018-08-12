package com.example.hyeokjin.knumeal;

import android.app.Application;

//전역변수를 보통 저장하기 위함
public class MyApplication extends Application {

    public boolean locationPermission; //permission이 부여되어있는가?

    public double longitude;
    public double altitude;
    public double latitude;
    public float accuracy;
    public String provider;


}
