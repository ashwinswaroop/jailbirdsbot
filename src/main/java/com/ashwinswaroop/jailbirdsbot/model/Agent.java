package com.ashwinswaroop.jailbirdsbot.model;

public class Agent {
    private String platformId;
    private String appId;
    private String appVersion;
    private String appUsername;

    public Agent(String platformId, String appId, String appVersion, String appUsername) {
        this.platformId = platformId;
        this.appId = appId;
        this.appVersion = appVersion;
        this.appUsername = appUsername;
    }

    public String getPlatformId() {
        return platformId;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getAppUsername() {
        return appUsername;
    }
}
