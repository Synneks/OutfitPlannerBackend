package com.lid.outfitplannerbackend.controllers;

import com.lid.outfitplannerbackend.model.Category;
import com.lid.outfitplannerbackend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CategoryController implements IController<Category> {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/categories")
    @Override
    public List<Category> getAll() {
        System.out.println(categoryService.getAll());
        return categoryService.getAll();
    }

    @GetMapping(value = "/categories/{id}")
    @Override
    public Category getById(@PathVariable int id) {
        System.out.println(categoryService.getById(id));
        return categoryService.getById(id);
    }
}
