package com.kosh.fullstack.controllers;

import com.kosh.fullstack.entities.User;
import com.kosh.fullstack.repository.UserRepository;
import com.kosh.fullstack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.save(newUser);
    }

    @GetMapping("api/v1/{userId}")
    public User getUser (@PathVariable Long userId){
        return userService.findById(userId).orElse(null);
    }

    @PutMapping("api/v1/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User updatedUser){
        return userService.updateUser(userId, updatedUser);
    }

    @DeleteMapping("api/v1/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteById(userId);
    }
}
