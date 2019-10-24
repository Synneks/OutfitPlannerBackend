package com.lid.outfitplannerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name="userid", nullable=false)
    private User user;

    @ManyToMany(mappedBy = "outfits")
    private Set<Clothing> clothing = new HashSet<>();

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Clothing> getClothing() {
        return clothing;
    }

    public void setClothing(Set<Clothing> clothing) {
        this.clothing = clothing;
    }
}
