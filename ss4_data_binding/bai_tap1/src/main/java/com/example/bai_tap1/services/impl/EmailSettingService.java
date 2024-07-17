package com.example.bai_tap1.services.impl;

import com.example.bai_tap1.models.EmailSetting;
import com.example.bai_tap1.repositories.IEmailSettingRepo;
import com.example.bai_tap1.services.IEmailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSettingService implements IEmailSettingService {
    @Autowired
    private IEmailSettingRepo emailSettingRepo;

    @Override
    public void add(EmailSetting mailSetting) {
        emailSettingRepo.add(mailSetting);
    }
}
