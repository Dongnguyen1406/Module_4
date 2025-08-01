package org.example.login_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LoginSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginSecurityApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("123")); // in ra chuỗi mã hóa
    }

}
