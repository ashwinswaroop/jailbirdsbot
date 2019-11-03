package com.ashwinswaroop.jailbirdsbot.reader;

import com.ashwinswaroop.jailbirdsbot.constants.Constants;
import com.ashwinswaroop.jailbirdsbot.loader.PropertiesLoader;
import com.ashwinswaroop.jailbirdsbot.loader.StreamLoader;
import com.ashwinswaroop.jailbirdsbot.model.Agent;

import java.io.InputStream;
import java.util.Properties;

public class AgentReader extends FileReader<Agent> {

    private StreamLoader expression;
    private Properties properties;

    public AgentReader() {
        expression = getExpression();
        properties = getProperties();
    }

    @Override
    protected StreamLoader getExpression() {
        return () -> {
            Properties properties = new Properties();
            InputStream propertiesStream = ClassLoader.getSystemResourceAsStream(Constants.APPLICATION_PROPERTIES);
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
    public Agent readFile() {
        String platformId = properties.getProperty(Constants.APPLICATION_PLATFORM);
        String appId = properties.getProperty(Constants.APPLICATION_ID);
        String appVersion = properties.getProperty(Constants.APPLICATION_VERSION);
        String appUsername = properties.getProperty(Constants.APPLICATION_USERNAME);
        return new Agent(platformId, appId, appVersion, appUsername);
    }
}
