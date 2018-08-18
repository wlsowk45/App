package com.example.hyeokjin.knumeal;

import android.widget.CheckBox;

public class Peopleitems {

    private String name;
    private boolean checked=true;

    public boolean isChecked() {
        return checked;
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

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}




