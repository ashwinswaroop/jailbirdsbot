package com.ashwinswaroop.jailbirdsbot.loader;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    private Properties properties = new Properties();


    public PropertiesLoader(StreamLoader streamLoader) {
        try {
            properties = streamLoader.loadStream();
        } catch (IOException e) {

        }
    }


    public Properties getConfigurationProperties() {
        return properties;
    }

}
