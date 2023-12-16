package com.exe1.jwtexe1.service;

import com.exe1.jwtexe1.configuration.JwtRequestFilter;
import com.exe1.jwtexe1.dao.OrderDetailsRepository;
import com.exe1.jwtexe1.dao.ProductDao;
import com.exe1.jwtexe1.dao.UserDao;
import com.exe1.jwtexe1.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {
    private static String ORDER_PLACED="Placed";
    @Autowired
    private OrderDetailsRepository orderRepository;
    @Autowired
    private ProductDao productDao;
    @Autowired
    UserDao userDao;
    public void placeOrder(OrderInput orderInput){
        List<OrderProductQuantity> orderProductQuantities = orderInput.getOrderProductQuantities();
        for(OrderProductQuantity o:orderProductQuantities){
           Product product= productDao.findById(o.getProductId()).get();
            String cuurent_user=JwtRequestFilter.CURRENT_USER;
            User user=userDao.findById(cuurent_user).get();
           OrderDetails orderDetail=new OrderDetails(
                    orderInput.getFullName(),
                    orderInput.getFullAdresse(),
                    orderInput.getContactNumber(),
                    orderInput.getAlternateContactNumber(),
                    ORDER_PLACED,
                    product.getProductDiscountPrice()*o.getQuantity(),
                    product,
                    user
            );
           orderRepository.save(orderDetail);
        }
    }
}
