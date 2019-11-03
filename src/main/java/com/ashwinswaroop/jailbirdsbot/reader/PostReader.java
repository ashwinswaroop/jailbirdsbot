package com.ashwinswaroop.jailbirdsbot.reader;

import com.ashwinswaroop.jailbirdsbot.loader.PropertiesLoader;
import com.ashwinswaroop.jailbirdsbot.loader.StreamLoader;
import com.ashwinswaroop.jailbirdsbot.model.Post;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

import static com.ashwinswaroop.jailbirdsbot.constants.Constants.*;

public class PostReader extends FileReader<Post> {

    private StreamLoader expression;
    private Properties properties;
    private String identifier;
    private String link;

    public PostReader(String identifier, String link) {
        expression = getExpression();
        properties = getProperties();
        this.identifier = identifier;
        this.link = link;
    }

    @Override
    protected StreamLoader getExpression() {
        return () -> {
            Properties properties = new Properties();
            InputStream propertiesStream = ClassLoader.getSystemResourceAsStream(LOCATION_PROPERTIES);
            properties.load(propertiesStream);
            return properties;
        };
    }

    @Override
    protected Properties getProperties() {
        return new PropertiesLoader(expression).getConfigurationProperties();
    }

    @Override
    public Post readFile() {
        List<String> args = new ArrayList();
        try (Stream<String> lines = Files.lines(Paths.get(properties.getProperty(LOCATION_DIRECTORY)+VIRGULE+identifier+ TXT), Charset.defaultCharset())) {
            lines.forEachOrdered(line -> {
                args.add(line);

            });
        } catch(IOException e) {
            e.printStackTrace();
        }
        return new Post(identifier, link, args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6), args.get(7), args.get(8));
    }
}
