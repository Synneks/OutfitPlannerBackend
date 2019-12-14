package com.lid.outfitplannerbackend.services;

import com.lid.outfitplannerbackend.model.Clothing;
import com.lid.outfitplannerbackend.model.Outfit;
import com.lid.outfitplannerbackend.persistence.OutfitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class OutfitService implements IService<Outfit> {

    private final OutfitRepository outfitRepository;
    private final ClothingService clothingService;

    @Autowired
    public OutfitService(OutfitRepository outfitRepository, ClothingService clothingService) {
        this.outfitRepository = outfitRepository;
        this.clothingService = clothingService;
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

    public List<Outfit> generateOutfits(int idClothing, String category) {
        Clothing mainClothing = clothingService.getById(idClothing);
        //mainColor = colorService.getMainColor(idClothing)
        //cer armonii
        //gasesc dupa categorie
        //returnez nr de haine in functie de category

        return null;
    }
}
