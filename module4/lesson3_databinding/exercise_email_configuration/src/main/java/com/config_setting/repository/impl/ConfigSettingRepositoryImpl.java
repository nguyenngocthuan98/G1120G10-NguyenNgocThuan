package com.config_setting.repository.impl;

import com.config_setting.model.ConfigSetting;
import com.config_setting.repository.ConfigSettingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConfigSettingRepositoryImpl implements ConfigSettingRepository {
    private static List<String> listLanguages;
    private static List<Integer> listPageSizes;
    private static List<ConfigSetting> listConfigSettings;

    static {
        listConfigSettings = new ArrayList<>();

        listLanguages = new ArrayList<>();
        listLanguages.add("English");
        listLanguages.add("Vietnamese");
        listLanguages.add("Japanese");
        listLanguages.add("Chinese");

        listPageSizes = new ArrayList<>();
        listPageSizes.add(5);
        listPageSizes.add(10);
        listPageSizes.add(15);
        listPageSizes.add(50);
        listPageSizes.add(100);
    }

    @Override
    public List<String> getListLanguage() {
        return listLanguages;
    }

    @Override
    public List<Integer> getListPageSize() {
        return listPageSizes;
    }

    @Override
    public void save(ConfigSetting configSetting) {
        listConfigSettings.add(configSetting);
    }

    @Override
    public ConfigSetting getConfigSetting() {
        return listConfigSettings.get(0);
    }

    @Override
    public void update(ConfigSetting configSetting) {
        listConfigSettings.clear();
        listConfigSettings.add(configSetting);
    }
}
