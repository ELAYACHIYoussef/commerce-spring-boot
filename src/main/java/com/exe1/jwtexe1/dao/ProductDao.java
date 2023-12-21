package com.exe1.jwtexe1.dao;


import com.exe1.jwtexe1.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Product,Integer> {
    public List<Product> findAll(Pageable pageable);

    List<Product> findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(String key1, String key2, Pageable pageable);

}
