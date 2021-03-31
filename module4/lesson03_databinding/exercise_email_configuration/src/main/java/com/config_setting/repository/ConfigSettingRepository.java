package com.config_setting.repository;

import com.config_setting.model.ConfigSetting;

import java.util.List;

public interface ConfigSettingRepository {
    List<String> getListLanguage();

    List<Integer> getListPageSize();

    void save(ConfigSetting configSetting);

    ConfigSetting getConfigSetting();

    void update(ConfigSetting configSetting);
}
