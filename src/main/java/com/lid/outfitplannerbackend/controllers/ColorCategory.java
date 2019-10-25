package com.lid.outfitplannerbackend.controllers;

import com.lid.outfitplannerbackend.model.Color;
import com.lid.outfitplannerbackend.services.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class ColorCategory implements IController<Color> {

    @Autowired
    ColorService colorService;

    @GetMapping(value = "/colors")
    @Override
    public List<Color> getAll() {
        System.out.println(colorService.getAll());
        return colorService.getAll();
    }

    @GetMapping(value = "/colors/{id}")
    @Override
    public Color getById(@PathVariable int id) {
        System.out.println(colorService.getById(id));
        return colorService.getById(id);
    }
}
