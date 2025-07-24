package org.example.validate_music_information;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ValidateMusicInformationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidateMusicInformationApplication.class, args);
    }

}
