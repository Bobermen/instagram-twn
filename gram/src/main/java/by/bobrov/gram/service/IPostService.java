package by.bobrov.gram.service;

import by.bobrov.gram.entity.PhotoPost;
import by.bobrov.gram.util.FilterConfig;

import java.util.List;

public interface IPostService {
    List<PhotoPost> getPage(int skip, int top, FilterConfig filterConfig);

    boolean addPost(PhotoPost photoPost);

    boolean editPost(PhotoPost newPhotoPost);

    PhotoPost getPost(int id);

    boolean removePost(int id);
}
