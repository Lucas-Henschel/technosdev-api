package com.technosdev.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codEmpl;

    @Column(nullable = false, length = 100)
    private String nmEmpl;

    @Column(nullable = false, length = 20)
    private String cpfEmpl;

    @Column(nullable = false)
    private boolean active;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public Employee() {
    }

    public Employee(Long codEmpl, String nmEmpl, String cpfEmpl, boolean active, Date createdAt) {
        this.codEmpl = codEmpl;
        this.nmEmpl = nmEmpl;
        this.cpfEmpl = cpfEmpl;
        this.active = active;
        this.createdAt = createdAt;
    }

    public Long getCodEmpl() {
        return codEmpl;
    }

    public void setCodEmpl(Long codEmpl) {
        this.codEmpl = codEmpl;
    }

    public String getNmEmpl() {
        return nmEmpl;
    }

    public void setNmEmpl(String nmEmpl) {
        this.nmEmpl = nmEmpl;
    }

    public String getCpfEmpl() {
        return cpfEmpl;
    }

    public void setCpfEmpl(String cpfEmpl) {
        this.cpfEmpl = cpfEmpl;
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
        Employee employee = (Employee) o;
        return Objects.equals(codEmpl, employee.codEmpl);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codEmpl);
    }
}

