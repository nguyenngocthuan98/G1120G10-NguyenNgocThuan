package com.config_setting.service;

import com.config_setting.model.ConfigSetting;

import java.util.List;

public interface ConfigSettingService {
    List<String> getListLanguage();

    List<Integer> getListPageSize();

    void save(ConfigSetting configSetting);

    ConfigSetting getConfigSetting();

    void update(ConfigSetting configSetting);

}
