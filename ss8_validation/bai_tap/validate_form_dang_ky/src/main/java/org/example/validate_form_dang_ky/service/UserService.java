package org.example.validate_form_dang_ky.service;

import org.example.validate_form_dang_ky.entity.User;
import org.example.validate_form_dang_ky.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
