package com.lid.outfitplannerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "types")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Type {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;

    @OneToMany(mappedBy="type")
    private Set<Clothing> clothes;

    public Type() {
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

    public Set<Clothing> getClothes() {
        return clothes;
    }

    public void setClothes(Set<Clothing> clothes) {
        this.clothes = clothes;
    }
}
