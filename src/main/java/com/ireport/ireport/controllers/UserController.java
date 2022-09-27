package com.ireport.ireport.controllers;

import com.ireport.ireport.entities.Post;
import com.ireport.ireport.entities.User;
import com.ireport.ireport.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable("id") long id){
        return userService.getOneUser(id);
    }

    @PostMapping("/users")
    public User postUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping ("/users/{id}")
    public Optional<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
        return userService.updateUser(id,user);
    }

}
