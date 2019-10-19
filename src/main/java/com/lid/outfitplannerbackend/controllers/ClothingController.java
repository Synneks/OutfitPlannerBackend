package com.lid.outfitplannerbackend.controllers;


import com.lid.outfitplannerbackend.DTOs.ClothingDTO;
import com.lid.outfitplannerbackend.model.Clothing;
import com.lid.outfitplannerbackend.services.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class ClothingController {

    @Autowired
    ClothingService clothingService;

    @GetMapping(value = "/clothes")
    public List<Clothing> getAll() {
        return clothingService.getAll();
    }


    @GetMapping(value = "/clothes/{id}")
    public ClothingDTO getById(@PathVariable int id) {
        Clothing clothing = clothingService.getById(id);
        ClothingDTO clothingDTO = new ClothingDTO();
        clothingDTO.setId(clothing.getId());
        String myPicture = new String(clothing.getPicture());
        clothingDTO.setPicture(myPicture);
        return clothingDTO;
    }


    /*
    @GetMapping(value = "/clothes/{id}")
    public Clothing getById(@PathVariable int id) {
        return clothingService.getById(id);
    }
    */

    @PostMapping(value = "/clothes")
    public Clothing save(@RequestBody ClothingDTO clothingDTO) {
        byte[] myPicture = clothingDTO.getPicture().getBytes();
        Clothing clothing = new Clothing();
        clothing.setId(clothingDTO.getId());
        clothing.setPicture(myPicture);
        return clothingService.insert(clothing);
    }
}
