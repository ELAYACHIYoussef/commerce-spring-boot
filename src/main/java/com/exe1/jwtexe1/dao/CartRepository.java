package com.exe1.jwtexe1.dao;


import com.exe1.jwtexe1.entity.Cart;
import com.exe1.jwtexe1.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
 public List<Cart> findByUser(User user);
}
