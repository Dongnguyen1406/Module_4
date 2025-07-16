package org.example.hom_thu_dien_tu.service.impl;

import org.example.hom_thu_dien_tu.model.EmailConfig;
import org.example.hom_thu_dien_tu.repository.EmailRepo;
import org.example.hom_thu_dien_tu.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private EmailRepo emailRepo;

    @Override
    public EmailConfig getConfig() {
        return emailRepo.getConfig();
    }

    @Override
    public void updateConfig(EmailConfig config) {
        emailRepo.updateConfig(config);
    }
}
