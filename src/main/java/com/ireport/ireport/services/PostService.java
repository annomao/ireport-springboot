package com.ireport.ireport.services;

import com.ireport.ireport.dto.PostCreateRequest;
import com.ireport.ireport.entities.Post;
import com.ireport.ireport.entities.User;
import com.ireport.ireport.repositories.PostRepository;
import com.ireport.ireport.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Post createPost (long id,PostCreateRequest post){
        Post post1 = new Post();
        User user = userRepository.getReferenceById(id);
        post1.setTitle(post.getTitle());
        post1.setBody(post.getBody());
        user.addPost(post1);
        userRepository.save(user);
        return  post1;
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
