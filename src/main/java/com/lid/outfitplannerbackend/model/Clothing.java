package com.lid.outfitplannerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clothes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Clothing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Lob
    @Column(name = "picture")
    private byte[] picture;

    @ManyToOne
    @JoinColumn(name="userid", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="typeid", nullable=false)
    private Type type;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "clothes_categories",
            joinColumns = { @JoinColumn(name = "clothingid") },
            inverseJoinColumns = { @JoinColumn(name = "categoryid") }
    )
    private Set<Category> categories = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "clothes_colors",
            joinColumns = { @JoinColumn(name = "clothingid") },
            inverseJoinColumns = { @JoinColumn(name = "colorid") }
    )
    private Set<Color> colors = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "outfits_clothes",
            joinColumns = { @JoinColumn(name = "clothingid") },
            inverseJoinColumns = { @JoinColumn(name = "outfitid") }
    )
    private Set<Outfit> outfits = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Color> getColors() {
        return colors;
    }

    public void setColors(Set<Color> colors) {
        this.colors = colors;
    }

    public Set<Outfit> getOutfits() {
        return outfits;
    }

    public void setOutfits(Set<Outfit> outfits) {
        this.outfits = outfits;
    }
}
