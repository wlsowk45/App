package com.example.hyeokjin.knumeal;

public class Peopleitems {

    String name;
    int checked;


    public Peopleitems(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {

        if(checked==0)
            return false;
        else
            return true;
    }

    public void setChecked(boolean checked) {
        if(!checked)
            this.checked = 0;
        else
            this.checked = 1;
    }
}




