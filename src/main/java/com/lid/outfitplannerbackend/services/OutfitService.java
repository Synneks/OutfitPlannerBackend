package com.lid.outfitplannerbackend.services;

import com.lid.outfitplannerbackend.model.Clothing;
import com.lid.outfitplannerbackend.model.Color;
import com.lid.outfitplannerbackend.model.Outfit;
import com.lid.outfitplannerbackend.persistence.OutfitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class OutfitService implements IService<Outfit> {

    private final OutfitRepository outfitRepository;
    private final ClothingService clothingService;
    private final ColorService colorService;

    @Autowired
    public OutfitService(OutfitRepository outfitRepository, ClothingService clothingService, ColorService colorService) {
        this.outfitRepository = outfitRepository;
        this.clothingService = clothingService;
        this.colorService = colorService;
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

    public Set<Outfit> generateOutfits(int idClothing, String category) {
        Clothing clothing = clothingService.getById(idClothing);
        //mainColor = colorService.getMainColor(idClothing)
        //cer armonii
        //gasesc dupa categorie
        //returnez nr de haine in functie de category
        Set<Outfit> outfits = new HashSet<>();
        List<Color> colors = clothing.getColors();
        Color firstColor = null;
        for (Color color : colors) {
            if (!color.getName().equals("white") && !color.getName().equals("gray") && !color.getName().equals("black")) {
                firstColor = color;
            }
        }
        if (firstColor == null) {
            firstColor = colors.get(0);
        }
        List<List<Color>> colorHarmonies = colorService.getAllMatchingCombinations(firstColor);
        for (List<Color> colorHarmony : colorHarmonies) {
        }
        return outfits;
    }
}
