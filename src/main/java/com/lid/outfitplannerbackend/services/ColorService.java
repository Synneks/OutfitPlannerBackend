package com.lid.outfitplannerbackend.services;

import com.lid.outfitplannerbackend.model.Color;
import com.lid.outfitplannerbackend.persistence.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ColorService implements IService<Color> {

    @Autowired
    private ColorRepository colorRepository;

    public ColorService() {
    }

    @Transactional
    @Override
    public List<Color> getAll() {
        return colorRepository.findAll();
    }

    @Transactional
    @Override
    public Color getById(int id) {
        return colorRepository.getOne(id);
    }
}