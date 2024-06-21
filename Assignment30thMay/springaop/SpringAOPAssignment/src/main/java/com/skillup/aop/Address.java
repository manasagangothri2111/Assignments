package com.skillup.aop;

public class Address {
    private int streetnum;
    private String city;
    private String state;

    public int getStreetnum() {
        return streetnum;
    }

    public void setStreetnum(int streetnum) {
        this.streetnum = streetnum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetnum=" + streetnum +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
