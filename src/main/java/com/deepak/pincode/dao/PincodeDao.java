package com.deepak.pincode.dao;

import com.deepak.pincode.entities.Pincode;

import java.util.List;


public interface PincodeDao {
    public List<Pincode> getListBypPincode(int pincode);

    public List<Pincode> getListByOfficeName(String office);

}
