package com.java14.Jpa2.services;

import com.java14.Jpa2.entity.OrderEntity;

import java.util.List;

public interface OrderServices {
    List<OrderEntity> getTop5Orders();
}
