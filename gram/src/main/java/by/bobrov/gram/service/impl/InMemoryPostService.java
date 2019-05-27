package by.bobrov.gram.service.impl;

import by.bobrov.gram.entity.PhotoPost;
import by.bobrov.gram.service.IPostService;
import by.bobrov.gram.util.FilterConfig;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryPostService implements IPostService {

    private ArrayList<PhotoPost> photoPosts;

    public InMemoryPostService() {
        photoPosts = new ArrayList<>();
        ArrayList<String> hashTags = new ArrayList<>(Arrays.asList("tag1", "tag2"));
        ArrayList<String> likes = new ArrayList<>(Arrays.asList("like1", "like2"));
        PhotoPost post1 = new PhotoPost(
                1,
                "blablalba",
                new Date("2011/05/12"),
                "Ivan",
                "link1",
                likes,
                hashTags
        );
        PhotoPost post2 = new PhotoPost(
                2,
                "KOKOKO",
                new Date("2019/01/14"),
                "Sashenka",
                "link2",
                likes,
                hashTags
        );
        PhotoPost post3 = new PhotoPost(
                3,
                "hello kek",
                new Date("2016/06/21"),
                "Masha",
                "link3",
                likes,
                hashTags
        );
        photoPosts.add(post1);
        photoPosts.add(post2);
        photoPosts.add(post3);
    }

    @Override
    public PhotoPost getPost(int id) {
        return photoPosts.stream().filter(photoPost -> photoPost.getId() == id).findFirst().get();
    }


    static int boolToInt(boolean b) {
        return Boolean.compare(b, false);
    }

    @Override
    public List<PhotoPost> getPage(final int skip,
                                   final int top,
                                   final FilterConfig filterConfig) {
        List<PhotoPost> resultPhotoPosts = photoPosts
                .stream()
                .filter(photoPost ->
                        (filterConfig.getAuthors() == null || filterConfig.getAuthors().contains(photoPost.getAuthor()))
                                && (filterConfig.getHashTags() == null || photoPost.getHashTags().containsAll(filterConfig.getHashTags()))
                                && (filterConfig.getFromDate() == null || filterConfig.getFromDate().getTime() <= photoPost.getCreatedAt().getTime())
                                && (filterConfig.getToDate() == null || filterConfig.getToDate().getTime() >= photoPost.getCreatedAt().getTime()))
                .sorted(Comparator.comparing(PhotoPost::getCreatedAt).reversed())
                .collect(Collectors.toList());
        Collections.reverse(resultPhotoPosts);
        return resultPhotoPosts.subList(skip, Math.min(top, resultPhotoPosts.size()));
    }

    @Override
    public boolean addPost(PhotoPost post) {
        return photoPosts.add(post);
    }

    @Override
    public boolean removePost(int id) {
        return photoPosts.removeIf(photoPost -> photoPost.getId() == id);
    }

    @Override
    public boolean editPost(PhotoPost newPost) {
        for (int i = 0; i < photoPosts.size(); i++) {
            if (photoPosts.get(i).getId() == newPost.getId()) {
                photoPosts.set(i, newPost);
                return true;
            }
        }
        return false;
    }

    public ArrayList<PhotoPost> getPhotoPosts() {
        return photoPosts;
    }
}