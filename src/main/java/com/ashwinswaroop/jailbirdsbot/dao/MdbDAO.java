package com.ashwinswaroop.jailbirdsbot.dao;

import com.ashwinswaroop.jailbirdsbot.model.Post;
import com.mongodb.Block;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.ashwinswaroop.jailbirdsbot.constants.Constants.COLLECTION_JAILBIRDS;
import static com.ashwinswaroop.jailbirdsbot.constants.Constants.DB_NAME;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MdbDAO implements DAO<Post> {

    private MongoClient client;
    private MongoCollection<Post> collection;
    private Post post;

    public MdbDAO(MongoClient client) {
        this.client = client;
        this.collection = getCollection();
    }

    private MongoCollection<Post> getCollection() {
        return client.getDatabase(DB_NAME).getCollection(COLLECTION_JAILBIRDS, Post.class).withCodecRegistry(getCodecRegistry());
    }

    private CodecRegistry getCodecRegistry() {
        return fromRegistries(com.mongodb.MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
    }

    @Override
    public void insert(Post entry) {
        collection.insertOne(entry);
    }

    @Override
    public Post last() {
        Block<Post> getPost = post -> this.post = post;
        collection.find().forEach(getPost);
        return post;
    }

    /*
    public void count() {
        List<Post> list = collection.find(or(eq("hero1", "Axe"),eq("hero2", "Axe"),eq("hero3", "Axe"),eq("hero4", "Axe"),eq("hero5", "Axe"),eq("hero6", "Anti-Mage"),eq("hero7", "Axe"),eq("hero8", "Axe"))).into(new ArrayList<>());
        System.out.println(list.size());
    }
    */
}
