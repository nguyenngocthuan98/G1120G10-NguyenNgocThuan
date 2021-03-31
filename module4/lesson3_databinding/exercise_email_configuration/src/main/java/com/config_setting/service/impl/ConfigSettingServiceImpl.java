package com.config_setting.service.impl;

import com.config_setting.model.ConfigSetting;
import com.config_setting.repository.ConfigSettingRepository;
import com.config_setting.service.ConfigSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigSettingServiceImpl implements ConfigSettingService {
    @Autowired
    ConfigSettingRepository configSettingRepository;

    @Override
    public List<String> getListLanguage() {
        return configSettingRepository.getListLanguage();
    }

    @Override
    public List<Integer> getListPageSize() {
        return configSettingRepository.getListPageSize();
    }

    @Override
    public void save(ConfigSetting configSetting) {
        configSettingRepository.save(configSetting);
    }

    @Override
    public ConfigSetting getConfigSetting() {
        return configSettingRepository.getConfigSetting();
    }

    @Override
    public void update(ConfigSetting configSetting) {
        configSettingRepository.update(configSetting);
    }
}
