package com.example.mygadsapp.models;

public class LearnerLeadersModel extends BaseModel {
    String name, imageurl, hours, country;

    public LearnerLeadersModel(String name, String imageurl, String hours, String country) {
        this.name = name;
        this.imageurl = imageurl;
        this.hours = hours;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
