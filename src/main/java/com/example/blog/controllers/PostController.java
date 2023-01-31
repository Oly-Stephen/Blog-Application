package com.example.blog.controllers;

import com.example.blog.models.Account;
import com.example.blog.models.Post;
import com.example.blog.services.AccountService;
import com.example.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    private final AccountService accountService;

    public PostController(PostService postService, AccountService accountService) {
        this.postService = postService;
        this.accountService = accountService;
    }

    @GetMapping
    public String getAllPosts(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }

    @GetMapping("/{id}")
    public String getPostById(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        if (post != null) {
            model.addAttribute("post", post);
            return "post";
        } else {
            return "404";
        }
    }

    @GetMapping("/new")
    public String createNewPost(Model model){
        List<Account> accounts = accountService.findByEmail("oly@gmail.com");
        if(!accounts.isEmpty()){
            Account account = accounts.get(0);
            Post post = new Post();
            post.setAccount(account);
            model.addAttribute("post", post);
            return "post_new";
        }else{
            return "404";
        }
    }

    @PostMapping("/new")
    public String saveNewPost(@ModelAttribute Post post){
        postService.savePost(post);
        return "redirect:/posts/" + post.getId();
    }

    @PutMapping("/{id}")
    public String updatePost(@PathVariable Long id, Post post) {
        post.setId(id);
        postService.updatePost(post);
        return "redirect:/posts";
    }

    @DeleteMapping("/{id}")
    public String deletePostById(@PathVariable Long id) {
        postService.deletePostById(id);
        return "redirect:/posts";
    }

}