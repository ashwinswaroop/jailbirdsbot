package com.ashwinswaroop.jailbirdsbot.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import static com.ashwinswaroop.jailbirdsbot.constants.Constants.*;

public class MdbConnection extends DatabaseConnection<MongoClient> {

    private String username;
    private String password;
    private String hostname;
    private String db;
    private String options;

    public MdbConnection(String username, String password, String hostname, String db, String options) {
        this.username = username;
        this.password = password;
        this.hostname = hostname;
        this.options = options;
        this.db = db;
    }

    @Override
    protected String getConnectionString() {
        return MDB_PREFIX+username+COLON+password+AT+hostname+VIRGULE+db+QUESTION+options;
    }

    @Override
    public MongoClient getClient() {
        return MongoClients.create(getConnectionString());

    }
}
