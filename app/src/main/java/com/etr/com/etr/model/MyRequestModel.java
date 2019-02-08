package com.etr.com.etr.model;

public class MyRequestModel {
    private String name;
    private String Location;


    public MyRequestModel(String name, String location) {

        this.name = name;
        Location = location;
    }
    public MyRequestModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    @Override
    public String toString() {
        return "MyRequestModel{" +
                "name='" + name + '\'' +
                ", Location='" + Location + '\'' +
                '}';
    }
}
