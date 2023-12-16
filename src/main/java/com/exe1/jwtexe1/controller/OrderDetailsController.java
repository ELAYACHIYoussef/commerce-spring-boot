package com.exe1.jwtexe1.controller;


import com.exe1.jwtexe1.entity.OrderInput;
import com.exe1.jwtexe1.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderDetailsController {

    @Autowired
    OrderDetailsService orderService;
    @PreAuthorize("hasRole('User')")
    @PostMapping({"/placeOrder"})
    public void placeOrder(@RequestBody OrderInput orderInput){
        orderService.placeOrder(orderInput);
    }

}
