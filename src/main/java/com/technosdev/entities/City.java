package com.technosdev.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codCity")
    private Long id;

    @Column(nullable = false, length = 50 , name = "nmCity")
    private String name;

    @Column(nullable = false, length = 2 , name = "sg_uf")
    private String uf;

    public City() {
    }

    public City(Long codCity, String nmCity, String uf) {
        this.id = codCity;
        this.name = nmCity;
        this.uf = uf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
