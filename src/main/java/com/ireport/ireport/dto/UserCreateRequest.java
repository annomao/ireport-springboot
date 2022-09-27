package com.ireport.ireport.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserCreateRequest {
    @NotBlank(message = "Name can not be blank")
    private String name;
    @NotBlank(message = "Username can not be blank")
    private String username;
    @NotBlank(message = "Email can not be blank")
    @Email
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
