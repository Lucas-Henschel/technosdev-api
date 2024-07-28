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
    @Column(name = "codCompany")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cod_address")
    private Address address;

    @Column(nullable = false, length = 100 , name = "nmCompany")
    private String name;

    @Column(nullable = false, length = 30 , name = "nmrCnpj")
    private String cnpj;

    @Column(nullable = false, length = 50 , name = "nmEmail")
    private String email;

    @Column(nullable = false, length = 20 , name = "nmrPhone")
    private String phone;

    @Column(nullable = false, length = 100 , name = "companyUser")
    private String user;

    @Column(nullable = false, length = 1000 , name = "companyPassword")
    private String password;

    @Column(nullable = false , name = "active")
    private boolean active;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;

    public Company() {
    }

    public Company(Long codCompany, Address address, String nmCompany, String nmrCnpj, String nmEmail, String nmrPhone, String companyUser, String companyPassword, boolean active, Date createdAt) {
        this.id = codCompany;
        this.address = address;
        this.name = nmCompany;
        this.cnpj = nmrCnpj;
        this.email = nmEmail;
        this.phone = nmrPhone;
        this.user = companyUser;
        this.password = companyPassword;
        this.active = active;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
        return Objects.equals(id, company.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
