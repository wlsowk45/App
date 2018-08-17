package com.example.hyeokjin.knumeal;

import android.widget.CheckBox;

public class Peopleitems {

    String name;
    boolean checking;
    CheckBox checkBox;

    public Peopleitems(boolean checking) {
        this.checking = checking;
    }

    public boolean isChecking(CheckBox checkBox){
        if(checkBox.isChecked())
            return true;
        else
            return  false;

    }

    public Peopleitems(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}




