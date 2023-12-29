package com.exe1.jwtexe1.service;

import com.exe1.jwtexe1.configuration.JwtRequestFilter;
import com.exe1.jwtexe1.dao.CartRepository;
import com.exe1.jwtexe1.dao.ProductDao;
import com.exe1.jwtexe1.dao.UserDao;
import com.exe1.jwtexe1.entity.Cart;
import com.exe1.jwtexe1.entity.Product;
import com.exe1.jwtexe1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductDao productDao;


    @Autowired
    UserDao userDao;
    public Cart addToCart(Integer productId){
        Product product=productDao.findById(productId).get();

        String userName= JwtRequestFilter.CURRENT_USER;

        User user=null;
       if(userName!=null){
            user=userDao.findById(userName).get();
       }

        if(product !=null && user!=null){
          Cart cart=new Cart(product,user);
          return cartRepository.save(cart);
        }

        return null;
    }
}
