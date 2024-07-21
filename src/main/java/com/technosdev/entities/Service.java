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
    private Long codService;

    @ManyToOne
    @JoinColumn(name = "cod_company")
    private Company company;

    @Column(nullable = false, length = 100)
    private String nmService;

    @Column(nullable = false, length = 200)
    private String dsService;

    @Column(nullable = false)
    private Double prcService;

    @Column(updatable = false)
    private Date averageTi;

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
        this.codService = codService;
        this.company = company;
        this.nmService = nmService;
        this.dsService = dsService;
        this.prcService = prcService;
        this.averageTi = averageTi;
        this.active = active;
        this.createdAt = createdAt;
    }

    public Long getCodService() {
        return codService;
    }

    public void setCodService(Long codService) {
        this.codService = codService;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getNmService() {
        return nmService;
    }

    public void setNmService(String nmService) {
        this.nmService = nmService;
    }

    public String getDsService() {
        return dsService;
    }

    public void setDsService(String dsService) {
        this.dsService = dsService;
    }

    public Double getPrcService() {
        return prcService;
    }

    public void setPrcService(Double prcService) {
        this.prcService = prcService;
    }

    public Date getAverageTi() {
        return averageTi;
    }

    public void setAverageTi(Date averageTi) {
        this.averageTi = averageTi;
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
        return Objects.equals(codService, service.codService);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codService);
    }
}
