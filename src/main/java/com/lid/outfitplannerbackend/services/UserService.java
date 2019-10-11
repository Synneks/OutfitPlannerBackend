package com.lid.outfitplannerbackend.services;

import com.lid.outfitplannerbackend.model.User;
import com.lid.outfitplannerbackend.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService() {
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.getOne(id);
    }
}
