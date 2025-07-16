package org.example.hom_thu_dien_tu.repository;

import org.example.hom_thu_dien_tu.model.EmailConfig;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepo {
//    private EmailConfig config = new EmailConfig();

    private EmailConfig config = new EmailConfig("English", 25, false, "Thor\nKing, Asgard");


    public EmailConfig getConfig() {
        return config;
    }

    public void updateConfig(EmailConfig newConfig) {
        this.config = newConfig;
    }
}
