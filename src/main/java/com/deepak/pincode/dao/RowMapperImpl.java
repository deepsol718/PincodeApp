package com.deepak.pincode.dao;

import com.deepak.pincode.entities.Pincode;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RowMapperImpl implements RowMapper<Pincode> {
    @Override
    public Pincode mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pincode pincode = new Pincode();

        pincode.setPincode(rs.getInt(1));
        pincode.setOffice(rs.getString(2));
        pincode.setDistrict(rs.getString(3));
        pincode.setState(rs.getString(4));

        return pincode;
    }
}
