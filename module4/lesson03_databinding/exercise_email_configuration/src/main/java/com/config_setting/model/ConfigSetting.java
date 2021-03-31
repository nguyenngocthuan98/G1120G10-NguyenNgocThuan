package com.config_setting.model;

public class ConfigSetting {
    String language;
    int pageSize;
    boolean spamFilter;
    String signature;

    public ConfigSetting() {
    }

    public ConfigSetting(String language, int pageSize, boolean spamFilterABoolean, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamFilter = spamFilterABoolean;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
