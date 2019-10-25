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
    @Override
    public List<User> getAll() {
        System.out.println(userService.getAll());
        return userService.getAll();
    }

    @GetMapping(value = "/users/{id}")
    @Override
    public User getById(@PathVariable int id) {
        System.out.println(userService.getById(id));
        return userService.getById(id);
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
