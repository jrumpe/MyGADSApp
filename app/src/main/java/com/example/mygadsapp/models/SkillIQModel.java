package com.example.mygadsapp.models;

public class SkillIQModel extends BaseModel {
    String name, imageurl, score, country;

    public SkillIQModel(String name, String imageurl, String score, String country) {
        this.name = name;
        this.imageurl = imageurl;
        this.score = score;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
