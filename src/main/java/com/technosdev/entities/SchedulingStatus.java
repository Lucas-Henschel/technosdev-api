package com.technosdev.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class SchedulingStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codSchedulingStatus;

    @Column(nullable = false, length = 50)
    private Integer nmStatus;

    @Column(nullable = false)
    private boolean active;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;

    public SchedulingStatus() {
    }

    public SchedulingStatus(Long codSchedulingStatus, Integer nmStatus, boolean active, Date createdAt) {
        this.codSchedulingStatus = codSchedulingStatus;
        this.nmStatus = nmStatus;
        this.active = active;
        this.createdAt = createdAt;
    }

    public Long getCodSchedulingStatus() {
        return codSchedulingStatus;
    }

    public void setCodSchedulingStatus(Long codSchedulingStatus) {
        this.codSchedulingStatus = codSchedulingStatus;
    }

    public Integer getNmStatus() {
        return nmStatus;
    }

    public void setNmStatus(Integer nmStatus) {
        this.nmStatus = nmStatus;
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
        SchedulingStatus that = (SchedulingStatus) o;
        return Objects.equals(codSchedulingStatus, that.codSchedulingStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codSchedulingStatus);
    }
}
