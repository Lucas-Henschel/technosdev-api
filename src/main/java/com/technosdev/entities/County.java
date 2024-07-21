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
    private Long codMuni;

    @Column(nullable = false, length = 50)
    private String nmMuni;

    @Column(nullable = false, length = 2)
    private String sgUf;

    public County() {
    }

    public County(Long codMuni, String nmMuni, String sgUf) {
        this.codMuni = codMuni;
        this.nmMuni = nmMuni;
        this.sgUf = sgUf;
    }

    public Long getCodMuni() {
        return codMuni;
    }

    public void setCodMuni(Long codMuni) {
        this.codMuni = codMuni;
    }

    public String getNmMuni() {
        return nmMuni;
    }

    public void setNmMuni(String nmMuni) {
        this.nmMuni = nmMuni;
    }

    public String getSgUf() {
        return sgUf;
    }

    public void setSgUf(String sgUf) {
        this.sgUf = sgUf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        County county = (County) o;
        return Objects.equals(codMuni, county.codMuni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codMuni);
    }
}
