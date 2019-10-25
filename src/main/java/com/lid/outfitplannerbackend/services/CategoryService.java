package com.lid.outfitplannerbackend.services;

import com.lid.outfitplannerbackend.model.Category;
import com.lid.outfitplannerbackend.persistence.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CategoryService implements IService<Category> {

    @Autowired
    CategoryRepository categoryRepository;

    public CategoryService() {
    }

    @Transactional
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    @Override
    public Category getById(int id) {
        return categoryRepository.getOne(id);
    }
}
