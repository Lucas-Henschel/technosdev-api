package com.technosdev.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codService")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cod_company")
    private Company company;

    @Column(nullable = false, length = 100 , name = "nmService")
    private String name;

    @Column(nullable = false, length = 200 , name = "dsService")
    private String description;

    @Column(nullable = false , name = "prcService")
    private Double price;

    @Column(updatable = false , name = "averageTi")
    private Date averageTime;

    @Column(nullable = false)
    private boolean active;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public Service() {
    }

    public Service(Long codService, Long codCompany, Company company, String nmService, String dsService, Double prcService, Date averageTi, boolean active, Date createdAt) {
        this.id = codService;
        this.company = company;
        this.name = nmService;
        this.description = dsService;
        this.price = prcService;
        this.averageTime = averageTi;
        this.active = active;
        this.createdAt = createdAt;
    }

    public Long getCodService() {
        return id;
    }

    public void setCodService(Long codService) {
        this.id = codService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(Date averageTime) {
        this.averageTime = averageTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(id, service.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
