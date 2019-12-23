package com.lid.outfitplannerbackend.controllers;

import com.lid.outfitplannerbackend.DTOs.ClothingDtoMapper;
import com.lid.outfitplannerbackend.DTOs.OutfitDTO;
import com.lid.outfitplannerbackend.DTOs.OutfitDtoMapper;
import com.lid.outfitplannerbackend.model.Clothing;
import com.lid.outfitplannerbackend.model.Outfit;
import com.lid.outfitplannerbackend.services.ClothingService;
import com.lid.outfitplannerbackend.services.OutfitService;
import com.lid.outfitplannerbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class OutfitController {

    private final OutfitService outfitService;

    private final UserService userService;


    @Autowired
    public OutfitController(OutfitService outfitService, UserService userService) {
        this.outfitService = outfitService;
        this.userService = userService;
    }

    @GetMapping(value = "users/{userId}/outfits")
    public ResponseEntity getAll(@PathVariable int userId) {
        List<Outfit> outfits = userService.getById(userId).getOutfits();
        List<OutfitDTO> outfitDTOs = outfits.stream().map(OutfitDtoMapper::entityToDto).collect(Collectors.toList());
        if (!outfitDTOs.isEmpty()) {
            return new ResponseEntity<>(outfitDTOs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No outfits found!", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "users/{userId}/outfits/{id}")
    public ResponseEntity getById(@PathVariable int id, @PathVariable int userId) {
        Outfit outfit = outfitService.getById(id);
        if (outfit != null) {
            return new ResponseEntity<>(OutfitDtoMapper.entityToDto(outfit), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Outfit not found!", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "users/{userId}/outfits")
    public ResponseEntity save(@RequestBody Outfit outfit, @PathVariable int userId) {
        try {
            outfit = outfitService.insert(outfit);
            outfit = userService.insertOutfit(userId, outfit);
            return new ResponseEntity<>(OutfitDtoMapper.entityToDto(outfit), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Outfit could not be added to user!", HttpStatus.NOT_FOUND);
        }
    }


}
