package com.java14.Jpa2.services.Imp;

import com.java14.Jpa2.dto.CustomerDTO;
import com.java14.Jpa2.repository.CustomerRepository;
import com.java14.Jpa2.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServicesImp implements CustomerServices {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(item -> {
                    CustomerDTO customerDTO = new CustomerDTO();
                    customerDTO.setId(item.getId());
                    customerDTO.setName(item.getName());
                    customerDTO.setPhone(item.getPhone());
                    return customerDTO;
                }).toList();
    }
}
