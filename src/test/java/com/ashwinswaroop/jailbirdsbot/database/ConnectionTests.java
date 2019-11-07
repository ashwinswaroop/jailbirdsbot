package com.ashwinswaroop.jailbirdsbot.database;

import com.ashwinswaroop.jailbirdsbot.model.Connection;
import com.ashwinswaroop.jailbirdsbot.reader.ConnectionReader;
import com.mongodb.client.MongoClient;
import org.junit.jupiter.api.Test;

import static com.ashwinswaroop.jailbirdsbot.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConnectionTests {

    @Test
    void testMdbConnectionClient() {
        Connection connection = new ConnectionReader().readFile();
        MdbConnection mdbConnection = new MdbConnection(connection.getUsername(), connection.getPassword(), connection.getHostname(), connection.getDb(), connection.getOptions());
        MongoClient mongoClient = mdbConnection.getClient();
        assertNotNull(mongoClient.getClusterDescription().getShortDescription());
    }

    @Test
    void testMdbConnectionStringConstruction() {
        Connection connection = new ConnectionReader().readFile();
        MdbConnection mdbConnection = new MdbConnection(connection.getUsername(), connection.getPassword(), connection.getHostname(), connection.getDb(), connection.getOptions());
        assertEquals(mdbConnection.getConnectionString(), MDB_PREFIX+connection.getUsername()+COLON+connection.getPassword()+AT+connection.getHostname()+VIRGULE+connection.getDb()+QUESTION+connection.getOptions());
    }
}
