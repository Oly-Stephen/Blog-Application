package com.example.blog.services;

import com.example.blog.models.Post;

import java.util.List;

public interface PostService {
    Post savePost(Post post);
    List<Post> getAllPosts();
    Post getPostById(Long id);
    Post updatePost(Post post);
    void deletePostById(Long id);
}
