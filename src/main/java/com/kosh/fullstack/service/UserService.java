package com.kosh.fullstack.service;

import com.kosh.fullstack.entities.User;
import com.kosh.fullstack.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(Long userId, User updatedUser) {
        Optional<User> foundedUser = findById(userId);
        if(foundedUser.isPresent()){
            User user = foundedUser.get();
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            save(user);
            return updatedUser;
        }
        return null;
    }
}
