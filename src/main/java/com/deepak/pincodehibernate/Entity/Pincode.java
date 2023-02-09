package com.deepak.pincodehibernate.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="pincodehibernate")
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column(name="pincode")
    private int pincode;

    @Column(name="city")
    private String cityName;

    @Column(name="district")
    private String district;

    @Column(name = "state")
    private String state;

    public Pincode() {
    }

    public Pincode(int id, int pincode, String cityName, String district, String state) {
        this.id = id;
        this.pincode = pincode;
        this.cityName = cityName;
        this.district = district;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Pincode{" +
                "id=" + id +
                ", pincode=" + pincode +
                ", cityName='" + cityName + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public int getPincode() {
        return pincode;
    }

    public String getCityName() {
        return cityName;
    }

    public String getDistrict() {
        return district;
    }

    public String getState() {
        return state;
    }
}
