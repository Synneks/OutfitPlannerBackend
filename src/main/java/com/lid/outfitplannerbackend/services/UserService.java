package com.lid.outfitplannerbackend.services;

import com.lid.outfitplannerbackend.model.Clothing;
import com.lid.outfitplannerbackend.model.User;
import com.lid.outfitplannerbackend.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserService implements IService<User> {

    @Autowired
    private UserRepository userRepository;

    public UserService() {
    }

    @Transactional
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public User getById(int id) {
        return userRepository.getOne(id);
    }

    public Clothing insertClothing(int userId, Clothing clothing) {
        User user = userRepository.getOne(userId);
        user.getClothes().add(clothing);
        userRepository.save(user);
        return clothing;
    }

    @Transactional
    public User login(String username, String password) {
        return userRepository.getByUsernameAndPassword(username, password);
    }

    @Transactional
    public User register(String username, String password) {
        if (userRepository.getByUsername(username) != null) {
            return null;
        } else {
            userRepository.save(new User(username, password));
            return userRepository.getByUsernameAndPassword(username, password);
        }
    }
}
