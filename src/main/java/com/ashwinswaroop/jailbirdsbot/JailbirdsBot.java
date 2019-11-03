package com.ashwinswaroop.jailbirdsbot;

import com.ashwinswaroop.jailbirdsbot.dao.MdbDAO;
import com.ashwinswaroop.jailbirdsbot.database.MdbConnection;
import com.ashwinswaroop.jailbirdsbot.hosting.ImgClient;
import com.ashwinswaroop.jailbirdsbot.model.*;
import com.ashwinswaroop.jailbirdsbot.reader.*;
import com.mongodb.client.MongoClient;
import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkAdapter;
import net.dean.jraw.http.OkHttpNetworkAdapter;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.models.SubmissionKind;
import net.dean.jraw.oauth.OAuthHelper;
import net.dean.jraw.references.SubmissionReference;

import static com.ashwinswaroop.jailbirdsbot.constants.Constants.PNG;
import static com.ashwinswaroop.jailbirdsbot.constants.SubmissionConstants.POST_TITLE;

public class JailbirdsBot {
    public static void main(String[] args) {

        Connection connection = new ConnectionReader().readFile();
        MdbConnection mdbConnection = new MdbConnection(connection.getUsername(), connection.getPassword(), connection.getHostname(), connection.getDb(), connection.getOptions());
        MongoClient mongoClient = mdbConnection.getClient();

        MdbDAO mdbDAO = new MdbDAO(mongoClient);
        Post lastPost = mdbDAO.last();
        String nextIdentifier = String.valueOf(Integer.parseInt(lastPost.getIdentifier())+1);

        Hosting hosting = new HostingReader().readFile();
        ImgClient imgClient = new ImgClient(hosting.getClientId(),hosting.getDirectoryLocation(), nextIdentifier+PNG);
        String link = imgClient.uploadImage();

        Post newPost = new PostReader(nextIdentifier, link).readFile();
        mdbDAO.insert(newPost);

        Agent agent = new AgentReader().readFile();
        UserAgent userAgent = new UserAgent(agent.getPlatformId(), agent.getAppId(), agent.getAppVersion(), agent.getAppUsername());

        Credentials credentials = new CredentialsReader().readFile();
        net.dean.jraw.oauth.Credentials userCredentials = net.dean.jraw.oauth.Credentials.script(credentials.getUsername(), credentials.getPassword(),
                credentials.getClientId(), credentials.getClientSecret());

        NetworkAdapter adapter = new OkHttpNetworkAdapter(userAgent);
        RedditClient redditClient = OAuthHelper.automatic(adapter, userCredentials);
        SubmissionReference reference = redditClient.subreddit("test").submit(SubmissionKind.LINK, POST_TITLE+newPost.getDate(), link, true);
        //redditClient.submission(reference.getId()).reply("Test");

    }
}
