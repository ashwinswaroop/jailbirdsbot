package com.ashwinswaroop.jailbirdsbot.reader;

import com.ashwinswaroop.jailbirdsbot.loader.PropertiesLoader;
import com.ashwinswaroop.jailbirdsbot.loader.StreamLoader;
import com.ashwinswaroop.jailbirdsbot.model.Connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import static com.ashwinswaroop.jailbirdsbot.constants.Constants.*;

public class ConnectionReader extends FileReader<Connection> {

    private StreamLoader expression;
    private Properties properties;

    public ConnectionReader() {
        expression = getExpression();
        properties = getProperties();
    }

    @Override
    protected StreamLoader getExpression() {
        return () -> {
            Properties properties = new Properties();
            InputStream propertiesStream = ClassLoader.getSystemResourceAsStream(LOCATION_PROPERTIES);
            properties.load(propertiesStream);
            String directoryLocation = properties.getProperty(LOCATION_DIRECTORY);
            String connectionFile = properties.getProperty(LOCATION_DB_CREDENTIALS);
            properties.clear();
            String connectionPath = directoryLocation+ VIRGULE +connectionFile;
            propertiesStream = new FileInputStream(connectionPath);
            properties.load(propertiesStream);
            propertiesStream.close();
            return properties;
        };
    }

    @Override
    protected Properties getProperties() {
        return new PropertiesLoader(expression).getConfigurationProperties();
    }

    @Override
    public Connection readFile() {
        String username = properties.getProperty(USERNAME);
        String password = properties.getProperty(PASSWORD);
        String hostname = properties.getProperty(HOSTNAME);
        String options = properties.getProperty(OPTIONS);
        String db = properties.getProperty(DB);
        return new Connection(username, password, hostname, db, options);
    }
}
