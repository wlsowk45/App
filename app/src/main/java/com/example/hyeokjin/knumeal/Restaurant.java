package com.example.hyeokjin.knumeal;

import android.os.Parcel;
import android.os.Parcelable;

public class Restaurant implements Parcelable {

    private int min_person;
    private String name;
    private double longitude;
    private double latitude;
    private String position;
    private int price;
    private int checked;
    private String phone_number;
    private int delivery;



    public Restaurant(String name, double latitude, double longitude, int min_person, String position, int price, String phone_number, int delivery) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.min_person = min_person;
        this.position = position;
        this.price = price;
        this.phone_number = phone_number;
        this.delivery = delivery;
    }



    private void readFromParcel(Parcel in) {

        name = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        min_person = in.readInt();
        position = in.readString();
        price = in.readInt();
        checked=in.readInt();
        phone_number=in.readString();
        delivery=in.readInt();

    }


    public Restaurant(Parcel in) {
        readFromParcel(in);
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        dest.writeInt(min_person);
        dest.writeString(position);
        dest.writeInt(price);
        dest.writeInt(checked);
        dest.writeString(phone_number);
        dest.writeInt(delivery);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public Restaurant createFromParcel(Parcel src) {
            return new Restaurant(src);
        }

        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }


    public void setMin_person(int min_person) {
        this.min_person = min_person;
    }

    public boolean isChecked() {
        if (checked == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public void setChecked(boolean checked) {
        if (checked == false) {
            this.checked = 0;
        } else {
            this.checked = 1;
        }
    }
}