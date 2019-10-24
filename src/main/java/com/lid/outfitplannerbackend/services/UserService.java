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
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User getById(int id) {
        return userRepository.getOne(id);
    }

    public Clothing insertClothing(int userId, Clothing clothing){
        User user = userRepository.getOne(userId);
        user.getClothes().add(clothing);
        userRepository.save(user);
        return clothing;
    }
}
