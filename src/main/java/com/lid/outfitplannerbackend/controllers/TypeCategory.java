package com.lid.outfitplannerbackend.controllers;

import com.lid.outfitplannerbackend.model.Type;
import com.lid.outfitplannerbackend.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class TypeCategory implements IController<Type> {

    @Autowired
    TypeService typeService;

    @GetMapping(value = "/types")
    @Override
    public List<Type> getAll() {
        System.out.println(typeService.getAll());
        return typeService.getAll();
    }

    @GetMapping(value = "/types/{id}")
    @Override
    public Type getById(@PathVariable int id) {
        System.out.println(typeService.getById(id));
        return typeService.getById(id);
    }
}
