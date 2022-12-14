package com.ireport.ireport.services;

import com.ireport.ireport.dto.UserCreateRequest;
import com.ireport.ireport.entities.Post;
import com.ireport.ireport.entities.User;
import com.ireport.ireport.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserCreateRequest user){
       User user1 = new User();
       user1.setName(user.getName());
       user1.setEmail(user.getEmail());
       user1.setUsername(user.getUsername());
        return userRepository.save(user1);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getOneUser(long id){
        return userRepository.findById(id);
    }

    public Optional<User> updateUser(long id, User user){
        var updateUser = userRepository.findById(id);
        updateUser.ifPresent( post1 -> {
            post1.setName(user.getName());
            post1.setUsername(user.getUsername());
            post1.setEmail(user.getEmail());
            userRepository.save(post1);
                });
        return updateUser;
    }
}
