package com.ashwinswaroop.jailbirdsbot.reader;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.ashwinswaroop.jailbirdsbot.model.*;
import org.junit.jupiter.api.Test;

public class ReaderTests {

    //Ideally we should be reading test files for these unit test cases
    //For now, we're reading real application files and credentials and only asserting not null for the sake of privacy

    @Test
    void testAgentReader() {
        Agent agent = new AgentReader().readFile();
        assertNotNull(agent.getAppId());
        assertNotNull(agent.getAppUsername());
        assertNotNull(agent.getAppVersion());
        assertNotNull(agent.getPlatformId());
    }

    @Test
    void testConnectionReader() {
        Connection connection = new ConnectionReader().readFile();
        assertNotNull(connection.getDb());
        assertNotNull(connection.getHostname());
        assertNotNull(connection.getOptions());
        assertNotNull(connection.getPassword());
        assertNotNull(connection.getUsername());
    }

    @Test
    void testCredentialsReader() {
        Credentials credentials = new CredentialsReader().readFile();
        assertNotNull(credentials.getClientId());
        assertNotNull(credentials.getClientSecret());
        assertNotNull(credentials.getPassword());
        assertNotNull(credentials.getUsername());
    }

    @Test
    void testHostingReader() {
        Hosting hosting = new HostingReader().readFile();
        assertNotNull(hosting.getClientId());
        assertNotNull(hosting.getDirectoryLocation());
        assertNotNull(hosting.getClientSecret());
    }

    @Test
    void testPostReader() {
        Post post = new PostReader("ID", "LINK").readFile();
        assertNotNull(post.getDate());
        assertNotNull(post.getIdentifier());
        assertNotNull(post.getHero1());
        assertNotNull(post.getHero2());
        assertNotNull(post.getHero3());
        assertNotNull(post.getHero4());
        assertNotNull(post.getHero5());
        assertNotNull(post.getHero6());
        assertNotNull(post.getHero7());
        assertNotNull(post.getHero8());
    }
}
