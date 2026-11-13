package com.java14.Jpa2.services.Imp;

import com.java14.Jpa2.entity.OrderEntity;
import com.java14.Jpa2.repository.OrderRepository;
import com.java14.Jpa2.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServicesImp implements OrderServices {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderEntity> getTop5Orders() {
        return orderRepository.findTop5ByOrderByTotalAmountDesc();
    }
}
