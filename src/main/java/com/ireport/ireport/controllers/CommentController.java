package com.ireport.ireport.controllers;

import com.ireport.ireport.dto.CommentCreateRequest;
import com.ireport.ireport.entities.Comment;
import com.ireport.ireport.services.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("comments")
    public List<Comment> getComments(){
        return commentService.getAllComments();
    }
    @GetMapping("/comments/{id}")
    public Optional<Comment> getOneComment(@PathVariable("id") long id){
        return commentService.getComment(id);
    }
    @PostMapping("comments")
    public Comment postComment(@Valid @RequestBody CommentCreateRequest comment){
        return commentService.createComment(comment);
    }
    @PutMapping("/comments/{id}")
    public Optional<Comment> update(@PathVariable("id") long id, @RequestBody Comment comment){
        return commentService.updateComment(id,comment);
    }
    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable("id") long id){
        commentService.deleteComment(id);
    }

}
