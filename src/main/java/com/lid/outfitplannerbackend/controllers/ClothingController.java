package com.lid.outfitplannerbackend.controllers;

import com.lid.outfitplannerbackend.DTOs.ClothingDTO;
import com.lid.outfitplannerbackend.DTOs.ClothingDtoMapper;
import com.lid.outfitplannerbackend.model.Clothing;
import com.lid.outfitplannerbackend.services.ClothingService;
import com.lid.outfitplannerbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class ClothingController {

    @Autowired
    ClothingService clothingService;

    @Autowired
    UserService userService;

    @GetMapping(value = "users/{userId}/clothes")
    public List<ClothingDTO> getAll(@PathVariable int userId) {
        List<Clothing> clothes = userService.getById(userId).getClothes();
        return clothes.stream().map(ClothingDtoMapper::entityToDto).collect(Collectors.toList());
    }

    @GetMapping(value = "users/{userId}/clothes/{id}")
    public ClothingDTO getById(@PathVariable int id, @PathVariable int userId) {
        Clothing clothing = clothingService.getById(id);
        return ClothingDtoMapper.entityToDto(clothing);
    }

    @PostMapping(value = "users/{userId}/clothes")
    public Clothing save(@RequestBody ClothingDTO clothingDTO, @PathVariable int userId) {
        Clothing clothing = clothingService.insert(ClothingDtoMapper.dtoToEntity(clothingDTO));
        return userService.insertClothing(userId, clothing);
    }
}
