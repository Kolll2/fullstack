package com.kosh.fullstack.service;

import com.kosh.fullstack.entities.User;
import com.kosh.fullstack.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }


    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(Long userId, User updatedUser) {
        User foundedUser = findById(userId);
        if (foundedUser == null) return null;
        foundedUser.setUsername(updatedUser.getUsername());
        foundedUser.setPassword(updatedUser.getPassword());
        save(foundedUser);
        return updatedUser;
    }
}
