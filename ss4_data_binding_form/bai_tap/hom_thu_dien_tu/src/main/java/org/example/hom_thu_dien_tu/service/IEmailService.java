package org.example.hom_thu_dien_tu.service;

import org.example.hom_thu_dien_tu.model.EmailConfig;

public interface IEmailService {
    EmailConfig getConfig();
    void updateConfig(EmailConfig config);
}
