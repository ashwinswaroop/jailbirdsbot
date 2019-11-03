package com.ashwinswaroop.jailbirdsbot.reader;

import com.ashwinswaroop.jailbirdsbot.loader.PropertiesLoader;
import com.ashwinswaroop.jailbirdsbot.loader.StreamLoader;
import com.ashwinswaroop.jailbirdsbot.model.Hosting;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import static com.ashwinswaroop.jailbirdsbot.constants.Constants.*;

public class HostingReader extends FileReader<Hosting> {

    private StreamLoader expression;
    private Properties properties;

    public HostingReader() {
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
            String credentialsFile = properties.getProperty(LOCATION_HOST_CREDENTIALS);
            properties.clear();
            String credentialsPath = directoryLocation+ VIRGULE +credentialsFile;
            propertiesStream = new FileInputStream(credentialsPath);
            properties.load(propertiesStream);
            properties.put(LOCATION_DIRECTORY, directoryLocation);
            propertiesStream.close();
            return properties;
        };
    }

    @Override
    protected Properties getProperties() {
        return new PropertiesLoader(expression).getConfigurationProperties();
    }

    @Override
    public Hosting readFile() {
        String clientId = properties.getProperty(CLIENT_ID);
        String clientSecret = properties.getProperty(CLIENT_SECRET);
        String directoryLocation = properties.getProperty(LOCATION_DIRECTORY);
        return new Hosting(clientId, clientSecret, directoryLocation);
    }
}
