package com.kosh.fullstack.controllers;

import com.kosh.fullstack.entities.User;
import com.kosh.fullstack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("api/v1/{userId}")
    public User getUser (@PathVariable Long userId){
        return userRepository.findById(userId).orElse(null);
    }

    @PutMapping("api/v1/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User updatedUser){
        Optional<User> foundedUser = userRepository.findById(userId);

        if(foundedUser.isPresent()){
            User user = foundedUser.get();
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            userRepository.save(user);
            return updatedUser;
        }

        return null;
    }

    @DeleteMapping("api/v1/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userRepository.deleteById(userId);
    }
}
