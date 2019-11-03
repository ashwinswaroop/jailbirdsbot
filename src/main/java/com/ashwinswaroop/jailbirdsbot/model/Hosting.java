package com.ashwinswaroop.jailbirdsbot.model;

public class Hosting {
    private String clientId;
    private String clientSecret;
    private String directoryLocation;

    public Hosting(String clientId, String clientSecret, String directoryLocation) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.directoryLocation = directoryLocation;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getDirectoryLocation() {
        return directoryLocation;
    }
}
