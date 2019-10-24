package com.lid.outfitplannerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "colors")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Color {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private int r;
    @Column
    private int g;
    @Column
    private int b;

    @ManyToMany(mappedBy = "colors")
    private Set<Clothing> clothing = new HashSet<>();

    public Color() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Set<Clothing> getClothing() {
        return clothing;
    }

    public void setClothing(Set<Clothing> clothing) {
        this.clothing = clothing;
    }
}
