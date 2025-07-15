package org.example.sandwichmanagement.service.impl;

import org.example.sandwichmanagement.repository.CondimentRepo;
import org.example.sandwichmanagement.service.ICondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondimentService implements ICondimentService {
    @Autowired
    private CondimentRepo condimentRepo;
    
    @Override
    public List<String> getCondimentList() {
        return condimentRepo.getAllCondiments();
    }
}
