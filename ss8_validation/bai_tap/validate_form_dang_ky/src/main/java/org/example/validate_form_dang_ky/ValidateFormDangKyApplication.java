package org.example.validate_form_dang_ky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ValidateFormDangKyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidateFormDangKyApplication.class, args);
    }

}
