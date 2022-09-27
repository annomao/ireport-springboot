package com.ireport.ireport.controllers;

import com.ireport.ireport.entities.Post;
import com.ireport.ireport.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> getPosts(){
        return postService.getAllPosts();
    }
    @GetMapping("/posts/{id}")
    public Optional<Post> getPost(@PathVariable("id") long id){
        return postService.getOnePost(id);
    }

    @PostMapping("/posts")
    public Post sendPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @PutMapping ("/posts/{id}")
    public Optional<Post> updatePost(@PathVariable("id") long id, @RequestBody Post post){
        return postService.updatePost(id,post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable("id") long id){
        postService.deletePost(id);
    }
}
