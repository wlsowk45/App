package com.example.hyeokjin.knumeal;

import android.app.Application;

public class Restaurant extends Application {

    private int min_person;
    private String name;
    private double longitude;
    private double latitude;


    public Restaurant(String name, double longitude, double latitude, int min_person)
    {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.min_person = min_person;
    }



    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getMin_person() {

        return min_person;
    }

    public void setMin_person(int min_person) {
        this.min_person = min_person;
    }

}
