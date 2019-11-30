package com.lid.outfitplannerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "colors")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Color implements Comparable<Color> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private double centerHsv;
    @Column
    private double endHsv;

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

    public double getCenterHsv() {
        return centerHsv;
    }

    public void setCenterHsv(double centerHsv) {
        this.centerHsv = centerHsv;
    }

    public double getEndHsv() {
        return endHsv;
    }

    public void setEndHsv(double endHsv) {
        this.endHsv = endHsv;
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", centerHsv=" + centerHsv +
                ", endHsv=" + endHsv +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return id == color.id &&
                Double.compare(color.centerHsv, centerHsv) == 0 &&
                Double.compare(color.endHsv, endHsv) == 0 &&
                Objects.equals(name, color.name);
    }

    @Override
    public int compareTo(Color o) {
        return Double.compare(this.centerHsv, o.centerHsv);
    }
}

