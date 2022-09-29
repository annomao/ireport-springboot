package com.ireport.ireport.dto;

import javax.validation.constraints.NotBlank;

public class CommentCreateRequest {
    @NotBlank(message = "Comment field can not be left blank")
    private String commentBody;

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }
}
