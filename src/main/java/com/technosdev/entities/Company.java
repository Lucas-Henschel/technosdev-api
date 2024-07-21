package com.technosdev.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCompany;

    @ManyToOne
    @JoinColumn(name = "cod_address")
    private Address address;

    @Column(nullable = false, length = 100)
    private String nmCompany;

    @Column(nullable = false, length = 30)
    private String nmrCnpj;

    @Column(nullable = false, length = 50)
    private String nmEmail;

    @Column(nullable = false, length = 20)
    private String nmrPhone;

    @Column(nullable = false, length = 100)
    private String companyUser;

    @Column(nullable = false, length = 1000)
    private String companyPassword;

    @Column(nullable = false)
    private boolean active;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;

    public Company() {
    }

    public Company(Long codCompany, Address address, String nmCompany, String nmrCnpj, String nmEmail, String nmrPhone, String companyUser, String companyPassword, boolean active, Date createdAt) {
        this.codCompany = codCompany;
        this.address = address;
        this.nmCompany = nmCompany;
        this.nmrCnpj = nmrCnpj;
        this.nmEmail = nmEmail;
        this.nmrPhone = nmrPhone;
        this.companyUser = companyUser;
        this.companyPassword = companyPassword;
        this.active = active;
        this.createdAt = createdAt;
    }

    public Long getCodCompany() {
        return codCompany;
    }

    public void setCodCompany(Long codCompany) {
        this.codCompany = codCompany;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getNmCompany() {
        return nmCompany;
    }

    public void setNmCompany(String nmCompany) {
        this.nmCompany = nmCompany;
    }

    public String getNmrCnpj() {
        return nmrCnpj;
    }

    public void setNmrCnpj(String nmrCnpj) {
        this.nmrCnpj = nmrCnpj;
    }

    public String getNmEmail() {
        return nmEmail;
    }

    public void setNmEmail(String nmEmail) {
        this.nmEmail = nmEmail;
    }

    public String getNmrPhone() {
        return nmrPhone;
    }

    public void setNmrPhone(String nmrPhone) {
        this.nmrPhone = nmrPhone;
    }

    public String getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(String companyUser) {
        this.companyUser = companyUser;
    }

    public String getCompanyPassword() {
        return companyPassword;
    }

    public void setCompanyPassword(String companyPassword) {
        this.companyPassword = companyPassword;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(codCompany, company.codCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codCompany);
    }
}
