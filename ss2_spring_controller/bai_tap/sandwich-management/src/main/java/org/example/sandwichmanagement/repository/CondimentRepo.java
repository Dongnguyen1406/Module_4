package org.example.sandwichmanagement.repository;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CondimentRepo {
    public List<String> getAllCondiments() {
        return Arrays.asList("Lettuce", "Tomato", "Mustard", "Sprouts");
    }
}
