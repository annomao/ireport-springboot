package com.ireport.ireport.dto;

import javax.validation.constraints.NotBlank;

public class PostCreateRequest {
    @NotBlank(message = "Title can not be left blank")
    private String title;
    @NotBlank(message = "Post body can not be blank")
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
