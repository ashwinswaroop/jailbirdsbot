package com.ashwinswaroop.jailbirdsbot.model;

public class Credentials {
    private String username;
    private String password;
    private String clientId;
    private String clientSecret;

    public Credentials(String username, String password, String clientId, String clientSecret) {
        this.username = username;
        this.password = password;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

}
