package by.bobrov.gram.entity;

import java.util.ArrayList;
import java.util.Date;

public class PhotoPost {
    private int id;
    private String description;
    private Date createdAt;
    private String author;
    private String photoLink;
    private ArrayList<String> likes;
    private ArrayList<String> hashTags;

    public PhotoPost(int id, String description, Date createdAt, String author,
                     String photoLink, ArrayList<String> likes, ArrayList<String> hashTags) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.author = author;
        this.photoLink = photoLink;
        this.likes = likes;
        this.hashTags = hashTags;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getAuthor() {
        return author;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public ArrayList<String> getLikes() {
        return likes;
    }

    public ArrayList<String> getHashTags() {
        return hashTags;
    }
}