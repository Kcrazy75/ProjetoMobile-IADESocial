package pt.iade.IADE_Social.service;

import java.util.List;

import pt.iade.IADE_Social.model.Post;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostByID(Integer id);
    Post createPost(Post post);
    Post updatePost(Post post, Integer id);
    void deletePostById(Integer id);
}
