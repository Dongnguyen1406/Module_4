package org.example.login_security.service;


import org.example.login_security.dto.UserInfoUserDetails;
import org.example.login_security.entity.AppUser;
import org.example.login_security.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInforDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iUserRepository.findByUserName(username);
        if(appUser == null) {
            System.out.println("Không tìm thấy user: " + username);
            throw new UsernameNotFoundException("User not found!");
        }
        System.out.println("Tìm thấy user: " + username + ", role: " + appUser.getAppRole().getRoleName());
        return new UserInfoUserDetails(appUser);
    }
}
