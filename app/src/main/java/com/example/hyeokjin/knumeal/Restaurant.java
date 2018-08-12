package com.example.hyeokjin.knumeal;

import android.os.Parcel;
import android.os.Parcelable;


public class Restaurant implements Parcelable {

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

    private void readFromParcel(Parcel in){
        name = in.readString();
        longitude = in.readDouble();
        latitude = in.readDouble();
        min_person = in.readInt();
    }


    public Restaurant(Parcel in){
        readFromParcel(in);
    }

    @Override
    public int describeContents(){
        return 0;
    }



    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(name);
        dest.writeDouble(longitude);
        dest.writeDouble(latitude);
        dest.writeInt(min_person);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public Restaurant createFromParcel(Parcel src) {
            return new Restaurant(src);
        }

        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
