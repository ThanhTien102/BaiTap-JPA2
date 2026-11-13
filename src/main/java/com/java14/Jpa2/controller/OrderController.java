package com.java14.Jpa2.controller;

import com.java14.Jpa2.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderServices orderServices;

    @GetMapping("/top")
    public ResponseEntity<?> getTop5Orders() {
        return ResponseEntity.ok(orderServices.getTop5Orders());
    }
}
