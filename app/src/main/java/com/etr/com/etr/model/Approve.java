package com.etr.com.etr.model;

public class Approve {
    private String name;
    private String Location;

    public Approve(String name, String location) {
        this.name = name;
        Location = location;
    }

    public Approve() {
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
        return "Approve{" +
                "name='" + name + '\'' +
                ", Location='" + Location + '\'' +
                '}';
    }
}
