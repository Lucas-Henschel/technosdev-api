package com.technosdev.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class ServiceOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codServiceOrder;

    @ManyToOne
    @JoinColumn(name = "cod_scheduling")
    private Scheduling scheduling;

    @ManyToOne
    @JoinColumn(name = "cod_service")
    private Service service;

    @Column(nullable = false)
    private Double priceOrderService;

    @Column(updatable = false)
    private Date finishedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public ServiceOrder() {
    }

    public ServiceOrder(Long codServiceOrder, Scheduling scheduling, Service service, Double priceOrderService, Date finishedAt, Date createdAt) {
        this.codServiceOrder = codServiceOrder;
        this.scheduling = scheduling;
        this.service = service;
        this.priceOrderService = priceOrderService;
        this.finishedAt = finishedAt;
        this.createdAt = createdAt;
    }

    public Long getCodServiceOrder() {
        return codServiceOrder;
    }

    public void setCodServiceOrder(Long codServiceOrder) {
        this.codServiceOrder = codServiceOrder;
    }

    public Scheduling getScheduling() {
        return scheduling;
    }

    public void setScheduling(Scheduling scheduling) {
        this.scheduling = scheduling;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Double getPriceOrderService() {
        return priceOrderService;
    }

    public void setPriceOrderService(Double priceOrderService) {
        this.priceOrderService = priceOrderService;
    }

    public Date getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(Date finishedAt) {
        this.finishedAt = finishedAt;
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
        ServiceOrder that = (ServiceOrder) o;
        return Objects.equals(codServiceOrder, that.codServiceOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codServiceOrder);
    }
}
