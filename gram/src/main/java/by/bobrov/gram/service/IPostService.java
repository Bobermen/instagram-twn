package by.bobrov.gram.service;

import by.bobrov.gram.entity.PhotoPost;
import by.bobrov.gram.util.FilterConfig;

import java.util.ArrayList;


public interface IPostService {
    ArrayList<PhotoPost> getPage(int skip, int limit, FilterConfig filterConfig);
    PhotoPost getPost(int id);
    boolean addPost(PhotoPost photoPost);
    boolean removePost(int id);
    boolean editPost(PhotoPost newPhotoPost);
}