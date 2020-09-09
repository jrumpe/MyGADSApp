package com.example.mygadsapp.models;

public class SubmitForm {
    String fname, lname, email, link;

    public SubmitForm(String fname, String lname, String email, String link) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.link = link;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
