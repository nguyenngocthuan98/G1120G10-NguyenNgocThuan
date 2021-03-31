package com.config_setting.controller;

import com.config_setting.model.ConfigSetting;
import com.config_setting.service.ConfigSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SettingEmailController {
    @Autowired
    ConfigSettingService configSettingService;

    @GetMapping("/")
    public ModelAndView getSettingView(Model model) {
        List<String> listLanguage = this.configSettingService.getListLanguage();
        model.addAttribute("listLanguage", listLanguage);
        List<Integer> listPageSize = this.configSettingService.getListPageSize();
        model.addAttribute("listPageSize", listPageSize);

        return new ModelAndView("setting", "configSetting", new ConfigSetting());
    }

    @PostMapping("/confirmSetting")
    public ModelAndView confirmSetting(@ModelAttribute ConfigSetting configSetting) {
        this.configSettingService.update(configSetting);
        return new ModelAndView("view", "configSetting", configSetting);
    }

    @GetMapping("/changeSettingPage")
    public ModelAndView editSetting(Model model) {
        ConfigSetting configSetting = this.configSettingService.getConfigSetting();

        List<String> listLanguage = this.configSettingService.getListLanguage();
        model.addAttribute("listLanguage", listLanguage);
        List<Integer> listPageSize = this.configSettingService.getListPageSize();
        model.addAttribute("listPageSize", listPageSize);

        return new ModelAndView("setting", "configSetting", configSetting);
    }
}
