package com.example.lyton.model;


public class Users {
    public String name;
    public String id;
    public String email;

    public Users(){}


    public Users(String name,String id,String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public String getName() { return name; }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
