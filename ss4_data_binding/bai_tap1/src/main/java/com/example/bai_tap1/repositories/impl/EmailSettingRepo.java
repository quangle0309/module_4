package com.example.bai_tap1.repositories.impl;

import com.example.bai_tap1.models.EmailSetting;
import com.example.bai_tap1.repositories.IEmailSettingRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailSettingRepo implements IEmailSettingRepo {
    private static List<EmailSetting> emailSettings = new ArrayList<>();

    @Override
    public void add(EmailSetting mailSetting) {
        emailSettings.add(mailSetting);
    }
}
