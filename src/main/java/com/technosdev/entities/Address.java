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
    private Long codAddress;

    @ManyToOne
    @JoinColumn(name = "cod_muni", nullable = false)
    private County county;

    @Column(nullable = false, length = 50)
    private String nmPublicPlace;

    @Column(nullable = false, length = 50)
    private String nmLocality;

    @Column(nullable = false, length = 8)
    private String nmCep;

    @Column(nullable = false, length = 100)
    private String dsComplement;

    public Address() {
    }

    public Address(Long codAddress, County county, String nmPublicPlace, String nmLocality, String nmCep, String dsComplement) {
        this.codAddress = codAddress;
        this.county = county;
        this.nmPublicPlace = nmPublicPlace;
        this.nmLocality = nmLocality;
        this.nmCep = nmCep;
        this.dsComplement = dsComplement;
    }

    public Long getCodAddress() {
        return codAddress;
    }

    public void setCodAddress(Long codAddress) {
        this.codAddress = codAddress;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public String getNmPublicPlace() {
        return nmPublicPlace;
    }

    public void setNmPublicPlace(String nmPublicPlace) {
        this.nmPublicPlace = nmPublicPlace;
    }

    public String getNmLocality() {
        return nmLocality;
    }

    public void setNmLocality(String nmLocality) {
        this.nmLocality = nmLocality;
    }

    public String getNmCep() {
        return nmCep;
    }

    public void setNmCep(String nmCep) {
        this.nmCep = nmCep;
    }

    public String getDsComplement() {
        return dsComplement;
    }

    public void setDsComplement(String dsComplement) {
        this.dsComplement = dsComplement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(codAddress, address.codAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codAddress);
    }
}
