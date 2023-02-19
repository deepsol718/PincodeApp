package com.deepak.pincode.entities;

import java.io.Serializable;

public class Pincode implements Serializable {
    private int pincode;

    private String office;

    private String district;

    private String state;

    public Pincode() {
    }

    public Pincode(int pincode, String office, String district, String state) {
        this.pincode = pincode;
        this.office = office;
        this.district = district;
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Pincode{" +
                "pincode=" + pincode +
                ", office='" + office + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
