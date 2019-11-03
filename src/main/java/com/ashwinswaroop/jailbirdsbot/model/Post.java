package com.ashwinswaroop.jailbirdsbot.model;

import org.bson.types.ObjectId;

public class Post {
    private ObjectId id;
    private String identifier;
    private String link;
    private String date;
    private String hero1;
    private String hero2;
    private String hero3;
    private String hero4;
    private String hero5;
    private String hero6;
    private String hero7;
    private String hero8;

    public Post() {
        
    }

    public Post(String identifier, String link, String date, String hero1, String hero2, String hero3, String hero4, String hero5, String hero6, String hero7, String hero8) {
        this.identifier = identifier;
        this.link = link;
        this.date = date;
        this.hero1 = hero1;
        this.hero2 = hero2;
        this.hero3 = hero3;
        this.hero4 = hero4;
        this.hero5 = hero5;
        this.hero6 = hero6;
        this.hero7 = hero7;
        this.hero8 = hero8;
    }

    public ObjectId getId() {
        return id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getLink() {
        return link;
    }

    public String getDate() {
        return date;
    }

    public String getHero1() {
        return hero1;
    }

    public String getHero2() {
        return hero2;
    }

    public String getHero3() {
        return hero3;
    }

    public String getHero4() {
        return hero4;
    }

    public String getHero5() {
        return hero5;
    }

    public String getHero6() {
        return hero6;
    }

    public String getHero7() {
        return hero7;
    }

    public String getHero8() {
        return hero8;
    }

    public void setId(final ObjectId id) {
        this.id = id;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHero1(String hero1) {
        this.hero1 = hero1;
    }

    public void setHero2(String hero2) {
        this.hero2 = hero2;
    }

    public void setHero3(String hero3) {
        this.hero3 = hero3;
    }

    public void setHero4(String hero4) {
        this.hero4 = hero4;
    }

    public void setHero5(String hero5) {
        this.hero5 = hero5;
    }

    public void setHero6(String hero6) {
        this.hero6 = hero6;
    }

    public void setHero7(String hero7) {
        this.hero7 = hero7;
    }

    public void setHero8(String hero8) {
        this.hero8 = hero8;
    }
}
