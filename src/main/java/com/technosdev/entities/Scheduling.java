package com.technosdev.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Scheduling implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codScheduling")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cod_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "cod_scheduling_status")
    private SchedulingStatus schedulingStatus;

    @ManyToOne
    @JoinColumn(name = "cod_company")
    private Company company;

    public Scheduling() {
    }

    public Scheduling(Long codScheduling, Client client, SchedulingStatus schedulingStatus, Company company) {
        this.id = codScheduling;
        this.client = client;
        this.schedulingStatus = schedulingStatus;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public SchedulingStatus getSchedulingStatus() {
        return schedulingStatus;
    }

    public void setSchedulingStatus(SchedulingStatus schedulingStatus) {
        this.schedulingStatus = schedulingStatus;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scheduling that = (Scheduling) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
