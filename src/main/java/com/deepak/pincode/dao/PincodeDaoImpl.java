package com.deepak.pincode.dao;

import com.deepak.pincode.entities.Pincode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.AliasFor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PincodeDaoImpl implements PincodeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapper<Pincode> rowMapper;

    @Override
    public List<Pincode> getListBypPincode(int pincode) {
        String query = "Select * from pincodedata where pincode = ?";
        List<Pincode> list = this.jdbcTemplate.query(query, rowMapper, pincode);
        return list;
    }

    @Override
    public List<Pincode> getListByOfficeName(String office) {
        office = office + " %";
        String query = "select * from pincodedata where office_name like ?";
        List<Pincode> list = this.jdbcTemplate.query(query,rowMapper,office);
        return list;
    }
}
