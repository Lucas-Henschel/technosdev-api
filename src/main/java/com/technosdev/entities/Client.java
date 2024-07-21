package com.technosdev.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codClient;

    @Column(nullable = false, length = 100)
    private String nmClient;

    @Column(nullable = false, unique = true, length = 20)
    private String nmrCpf;

    @Column(nullable = false, length = 25)
    private String nmrPhone;

    @Column(nullable = false)
    private boolean active;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;

    public Client() {
    }

    public Client(Long codClient, String nmClient, String nmrPhone, boolean active, String nmrCpf, Date createdAt) {
        this.codClient = codClient;
        this.nmClient = nmClient;
        this.nmrPhone = nmrPhone;
        this.active = active;
        this.nmrCpf = nmrCpf;
        this.createdAt = createdAt;
    }

    public Long getCodClient() {
        return codClient;
    }

    public void setCodClient(Long codClient) {
        this.codClient = codClient;
    }

    public String getNmClient() {
        return nmClient;
    }

    public void setNmClient(String nmClient) {
        this.nmClient = nmClient;
    }

    public String getNmrPhone() {
        return nmrPhone;
    }

    public void setNmrPhone(String nmrPhone) {
        this.nmrPhone = nmrPhone;
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

    public String getNmrCpf() {
        return nmrCpf;
    }

    public void setNmrCpf(String nmrCpf) {
        this.nmrCpf = nmrCpf;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(codClient, client.codClient);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codClient);
    }
}
