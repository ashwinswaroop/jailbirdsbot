package com.ashwinswaroop.jailbirdsbot.model;

public class Connection {
    private String username;
    private String password;
    private String hostname;
    private String db;
    private String options;

    public Connection(String username, String password, String hostname, String db, String options) {
        this.username = username;
        this.password = password;
        this.hostname = hostname;
        this.db = db;
        this.options = options;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getHostname() {
        return hostname;
    }

    public String getOptions() {
        return options;
    }

    public String getDb() {
        return db;
    }
}
