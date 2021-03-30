package com.example.lyton.model;

import android.media.Image;

public class Spot {

    private String name, country, city, address, description;
    private Image photo;

    public Spot(String name, String country, String city, String address, String description){
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.description = description;
    }

    public Spot(String name, String country, String city, String address, String description, Image photo){
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.description = description;
        this.photo = photo;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
