package com.deepak.pincodehibernate.dao;

import com.deepak.pincodehibernate.Entity.Pincode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PincodeRepository  extends CrudRepository<Pincode,Integer> {
    @Query(
            value="select * from pincodehibernate where city like :cityName ",
            nativeQuery = true)
    List<Pincode> findByCity(@Param("cityName") String city);

}
