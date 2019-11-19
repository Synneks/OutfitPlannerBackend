package com.lid.outfitplannerbackend.services;

import com.lid.outfitplannerbackend.model.Clothing;
import com.lid.outfitplannerbackend.persistence.ClothingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
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

    public void distinguishColors(int clothingId) throws IOException {
        int white=0;
        int black = 0;
        int red = 0;
        int yellow = 0;
        int green = 0;
        int cyan = 0;
        int blue = 0;
        int magenta = 0;
        Clothing clothing = getById(clothingId);
        String imageData = new String(clothing.getPicture());
        String base64Data = imageData.split(",")[1];
        byte[] decodedBytes = Base64.getDecoder().decode(base64Data);
        ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
        BufferedImage image = ImageIO.read(bis);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int  rgb   = image.getRGB(x, y);
                float[] hsb = new float[3];
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >>  8) & 0xFF;
                int b = (rgb      ) & 0xFF;
                Color.RGBtoHSB(r, g, b, hsb);
                if  (hsb[1] < 0.1 && hsb[2] > 0.9) white++;
                else if (hsb[2] < 0.1) black++;
                else {
                    float deg = hsb[0]*360;
                    if      (deg >=   0 && deg <  30) red++;
                    else if (deg >=  30 && deg <  90) yellow++;
                    else if (deg >=  90 && deg < 150) green++;
                    else if (deg >= 150 && deg < 210) cyan++;
                    else if (deg >= 210 && deg < 270) blue++;
                    else if (deg >= 270 && deg < 330) magenta++;
                    else red++;
                }
            }
        }
        System.out.println(white);
        System.out.println(black);
        System.out.println(red);
        System.out.println(yellow);
        System.out.println(green);
        System.out.println(cyan);
        System.out.println(blue);
        System.out.println(magenta);
    }
}
