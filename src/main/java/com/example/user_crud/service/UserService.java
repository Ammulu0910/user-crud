package com.example.user_crud.service;

import com.example.user_crud.model.User;
import com.example.user_crud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> addMultipleUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    public User updateUser(Long id, User userDetails) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existing.setName(userDetails.getName());
        existing.setEmail(userDetails.getEmail());
        existing.setPhone(userDetails.getPhone());
        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
