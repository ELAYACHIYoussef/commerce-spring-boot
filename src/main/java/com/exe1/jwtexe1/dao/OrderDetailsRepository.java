package com.exe1.jwtexe1.dao;


import com.exe1.jwtexe1.entity.OrderDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails,Integer> {
}
