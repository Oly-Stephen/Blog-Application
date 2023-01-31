package com.example.blog.services.impl;

import com.example.blog.models.Post;
import com.example.blog.repositories.PostRepository;
import com.example.blog.services.PostService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    @Transactional
    public Post savePost(Post post) {
        if (post.getDate() == null) {
            post.setDate(LocalDateTime.now());
        }
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post updatePost(Post post) {
        if (post.getDate() == null) {
            post.setDate(LocalDateTime.now());
        }
        return postRepository.save(post);
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }
}
