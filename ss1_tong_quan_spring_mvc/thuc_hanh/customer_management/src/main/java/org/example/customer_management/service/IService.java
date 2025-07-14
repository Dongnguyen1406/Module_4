package org.example.customer_management.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
}
