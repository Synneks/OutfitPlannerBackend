package com.lid.outfitplannerbackend.controllers;

import com.lid.outfitplannerbackend.model.User;
import com.lid.outfitplannerbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public List<User> getAll() {
        System.out.println(userService.getAllUsers());
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{userId}")
    public User getById(@PathVariable int userId) {
        System.out.println(userService.getUserById(userId));
        return userService.getUserById(userId);
    }
}