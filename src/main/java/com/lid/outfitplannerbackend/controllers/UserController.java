package com.lid.outfitplannerbackend.controllers;

import com.lid.outfitplannerbackend.model.User;
import com.lid.outfitplannerbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController implements IController<User> {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public List<User> getAll() {
        System.out.println(userService.getAll());
        return userService.getAll();
    }

    @GetMapping(value = "/users/{userId}")
    public User getById(@PathVariable int userId) {
        System.out.println(userService.getById(userId));
        return userService.getById(userId);
    }

    @PostMapping(value = "/login")
    public User login(@RequestBody User user) {
        User result = userService.login(user.getUsername(), user.getPassword());
        System.out.println(user);
        return result;
    }

    @PostMapping(value = "/register")
    public User register(@RequestBody User user) {
        User result = userService.register(user.getUsername(), user.getPassword());
        System.out.println(user);
        return result;
    }
}
