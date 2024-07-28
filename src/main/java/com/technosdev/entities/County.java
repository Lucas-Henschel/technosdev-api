package com.technosdev.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class County implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codMuni")
    private Long id;

    @Column(nullable = false, length = 50 , name = "nmMuni")
    private String name;

    @Column(nullable = false, length = 2 , name = "sgUf")
    private String uf;

    public County() {
    }

    public County(Long codMuni, String nmMuni, String sgUf) {
        this.id = codMuni;
        this.name = nmMuni;
        this.uf = sgUf;
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
        County county = (County) o;
        return Objects.equals(id, county.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
