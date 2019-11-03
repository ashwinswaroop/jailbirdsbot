package com.ashwinswaroop.jailbirdsbot.reader;

import com.ashwinswaroop.jailbirdsbot.loader.PropertiesLoader;
import com.ashwinswaroop.jailbirdsbot.loader.StreamLoader;
import com.ashwinswaroop.jailbirdsbot.model.Credentials;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import static com.ashwinswaroop.jailbirdsbot.constants.Constants.*;

public class CredentialsReader extends FileReader<Credentials> {

    private StreamLoader expression;
    private Properties properties;

    public CredentialsReader() {
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
            String credentialsFile = properties.getProperty(LOCATION_APP_CREDENTIALS);
            properties.clear();
            String credentialsPath = directoryLocation+ VIRGULE +credentialsFile;
            propertiesStream = new FileInputStream(credentialsPath);
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
    public Credentials readFile() {
        String username = properties.getProperty(USERNAME);
        String password = properties.getProperty(PASSWORD);
        String clientId = properties.getProperty(CLIENT_ID);
        String clientSecret = properties.getProperty(CLIENT_SECRET);
        return new Credentials(username, password, clientId, clientSecret);
    }
}
