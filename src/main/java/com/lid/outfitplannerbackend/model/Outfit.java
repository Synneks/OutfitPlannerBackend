package com.lid.outfitplannerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "outfits")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Outfit {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column
    private String name;

    @ManyToMany
    @JoinTable(
            name = "outfits_clothes",
            joinColumns = { @JoinColumn(name = "outfitid") },
            inverseJoinColumns = { @JoinColumn(name = "clothingid") }
    )
    private List<Clothing> clothes = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Clothing> getClothes() {
        return clothes;
    }

    public void setClothes(List<Clothing> clothes) {
        this.clothes = clothes;
    }
}
