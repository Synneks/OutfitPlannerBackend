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

   /*
        red 		    #ff0000		0
        red_orange      #ff4000		15
        orange 		    #ff8000		30
        amber	 	    #ffbf00		45
        yellow 		    #ffff00		60
        lime 		    #80ff00		90
        green 		    #00ff00		120
        cyan 		    #00ffff		180
        blue 		    #0000ff		240
        purple 		    #8000ff		270
        magenta 	    #ff00ff		300
        pink 		    #ff0080		330
        red 		    #ff0000		360
    */

    public void distinguishColors(int clothingId) throws IOException {
        int white = 0;
        int black = 0;
        int red = 0;
        int red_orange = 0;
        int orange = 0;
        int amber = 0;
        int yellow = 0;
        int lime = 0;
        int green = 0;
        int cyan = 0;
        int blue = 0;
        int purple = 0;
        int magenta = 0;
        int pink = 0;
        Clothing clothing = getById(clothingId);
        String imageData = new String(clothing.getPicture());
        String base64Data = imageData.split(",")[1];
        byte[] decodedBytes = Base64.getDecoder().decode(base64Data);
        ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
        BufferedImage image = ImageIO.read(bis);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                float[] hsb = new float[3];
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = (rgb) & 0xFF;
                Color.RGBtoHSB(r, g, b, hsb);
                if (hsb[1] < 0.1 && hsb[2] > 0.9) white++;
                else if (hsb[2] < 0.1) black++;
                else {
                    float deg = hsb[0] * 360;
                    if (deg >= 0 && deg < 7.5) red++;
                    else if (deg >= 7.5 && deg < 22.5) {
                        red_orange++;
                    } else if (deg >= 22.5 && deg < 37.5) {
                        orange++;
                    } else if (deg >= 37.5 && deg < 52.5) {
                        amber++;
                    } else if (deg >= 52.5 && deg < 75.0) {
                        yellow++;
                    } else if (deg >= 75.0 && deg < 105.0) {
                        lime++;
                    } else if (deg >= 105.0 && deg < 150.0) {
                        green++;
                    } else if (deg >= 150.0 && deg < 210.0) {
                        cyan++;
                    } else if (deg >= 210.0 && deg < 255.0) {
                        blue++;
                    } else if (deg >= 255.0 && deg < 285.0) {
                        purple++;
                    } else if (deg >= 285.0 && deg < 315.0) {
                        magenta++;
                    } else if (deg >= 315.0 && deg < 345.0) {
                        pink++;
                    } else red++;
                }
            }
        }
        System.out.println(red);
        System.out.println(red_orange);
        System.out.println(orange);
        System.out.println(amber);
        System.out.println(yellow);
        System.out.println(lime);
        System.out.println(green);
        System.out.println(cyan);
        System.out.println(blue);
        System.out.println(purple);
        System.out.println(magenta);
        System.out.println(pink);
    }
}
