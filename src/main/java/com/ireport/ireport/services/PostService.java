package com.ireport.ireport.services;

import com.ireport.ireport.entities.Post;
import com.ireport.ireport.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost (Post post){
        return postRepository.save(post);
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Optional<Post> getOnePost (long id){
        return postRepository.findById(id);
    }

    public void deletePost(long id){
        postRepository.deleteById(id);
    }

    public Optional<Post> updatePost(long id, Post post){
        var updatePost = postRepository.findById(id);
        updatePost.ifPresent( post1 -> {
            post1.setTitle(post.getTitle());
            post1.setBody(post.getBody());
            postRepository.save(post1);
        }
        );
        return updatePost;
    }
}
