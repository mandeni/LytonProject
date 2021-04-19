package com.example.lyton.model;
;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Spot {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name, country, city, address, description, photoUri;


    public Spot(String name, String country, String city, String address, String description, String photoUri){
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.description = description;
        this.photoUri = photoUri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUri() {
        return photoUri;
    }

    public void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
