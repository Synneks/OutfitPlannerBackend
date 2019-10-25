package com.lid.outfitplannerbackend.services;

import com.lid.outfitplannerbackend.model.Clothing;
import com.lid.outfitplannerbackend.persistence.ClothingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ClothingService implements IService<Clothing> {

    private final ClothingRepository clothingRepository;

    @Autowired
    public ClothingService(ClothingRepository clothingRepository) {
        this.clothingRepository = clothingRepository;
    }

    @Transactional
    @Override
    public List<Clothing> getAll() {
        return clothingRepository.findAll();
    }

    @Transactional
    @Override
    public Clothing getById(int id) {
        return clothingRepository.getOne(id);
    }

    public Clothing insert(Clothing clothing) {
        return clothingRepository.save(clothing);
    }
}
