package com.ireport.ireport.services;

import com.ireport.ireport.dto.CommentCreateRequest;
import com.ireport.ireport.entities.Comment;
import com.ireport.ireport.entities.Post;
import com.ireport.ireport.repositories.CommentRepository;
import com.ireport.ireport.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public Comment createComment(long id,CommentCreateRequest comment){
        Post post = postRepository.getReferenceById(id);
        Comment comment1 = new Comment();
        comment1.setCommentBody(comment.getCommentBody());
        post.addComment(comment1);
        postRepository.save(post);
        return comment1;
    }

    public Optional<Comment> getComment(long id){
        return commentRepository.findById(id);
    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public void deleteComment(long id){
        commentRepository.deleteById(id);
    }

    public Optional<Comment> updateComment(long id, Comment updatedComment){
       var updateComment = this.commentRepository.findById(id);
       updateComment.ifPresent(comment1 ->{
           comment1.setCommentBody(updatedComment.getCommentBody());
       });
       return updateComment;
    }
}
