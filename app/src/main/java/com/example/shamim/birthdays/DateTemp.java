package com.example.shamim.birthdays;

/**
 * Created by Shamim on 05-Jan-18.
 */

public class DateTemp {

    private int id;
    private  String name;
    private  String day;


    public DateTemp(String n,String d){
        name = n;
        day =d ;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
