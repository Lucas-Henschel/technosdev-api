package com.technosdev.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codAddress")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cod_muni", nullable = false)
    private City city;

    @Column(nullable = false, length = 50 , name = "nmPublicPlace")
    private String publicPlace;

    @Column(nullable = false, length = 50, name = "nmLocality")
    private String locality;

    @Column(nullable = false, length = 8 , name = "nmCep")
    private String cep;

    @Column(nullable = false, length = 100 , name = "dsComplement")
    private String complement;

    public Address() {
    }

    public Address(Long codAddress, City city, String nmPublicPlace, String nmLocality, String nmCep, String dsComplement) {
        this.id = codAddress;
        this.city = city;
        this.publicPlace = nmPublicPlace;
        this.locality = nmLocality;
        this.cep = nmCep;
        this.complement = dsComplement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
