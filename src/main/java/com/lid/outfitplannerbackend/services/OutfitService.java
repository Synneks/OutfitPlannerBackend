package com.lid.outfitplannerbackend.services;

import com.lid.outfitplannerbackend.model.Outfit;
import com.lid.outfitplannerbackend.persistence.OutfitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class OutfitService implements IService<Outfit> {

    private final OutfitRepository outfitRepository;

    @Autowired
    public OutfitService(OutfitRepository outfitRepository) {
        this.outfitRepository = outfitRepository;
    }

    @Transactional
    @Override
    public List<Outfit> getAll() {
        return outfitRepository.findAll();
    }

    @Transactional
    @Override
    public Outfit getById(int id) {
        return outfitRepository.getOne(id);
    }

    public Outfit insert(Outfit outfit) {
        return outfitRepository.save(outfit);
    }

    public Outfit update(Outfit outfit) {
        return outfitRepository.save(outfit);
    }
}
