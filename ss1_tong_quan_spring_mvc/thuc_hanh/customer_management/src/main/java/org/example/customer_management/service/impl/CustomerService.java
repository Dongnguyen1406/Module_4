package org.example.customer_management.service.impl;

import org.example.customer_management.repository.CustomerRepository;
import org.example.customer_management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    
    @Override
    public List findAll() {
        return customerRepository.findAll();
    }
}
