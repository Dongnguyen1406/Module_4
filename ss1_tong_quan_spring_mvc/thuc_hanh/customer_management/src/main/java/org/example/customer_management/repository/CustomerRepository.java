package org.example.customer_management.repository;

import org.example.customer_management.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository {
    private static List<Customer> customers = new ArrayList<>();
    
    static {
        customers.add(new Customer(1, "Nguyen Khac Nhat", "nhat@codegym.vn", "Hà Nội"));
    }
    
    public List<Customer> findAll(){
        return customers;
    }
    
    
}
