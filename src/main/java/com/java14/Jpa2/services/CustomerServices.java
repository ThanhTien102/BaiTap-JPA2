package com.java14.Jpa2.services;

import com.java14.Jpa2.dto.CustomerDTO;

import java.util.List;

public interface CustomerServices {
    List<CustomerDTO> getAllCustomers();
}
