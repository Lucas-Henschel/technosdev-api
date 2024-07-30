package com.technosdev.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codClient")
    private Long id;

    @NotBlank(message = "O campo nome é obrigatório")
    @Size(min = 1, max = 100, message = "O nome tem que ter no máximo 100 caracteres")
    @Column(nullable = false, length = 100 , name = "nmClient")
    private String name;

    @NotBlank(message = "O campo CPF é obrigatório")
    @CPF(message = "Formato de CPF inválido. Certifique-se de que o CPF esteja no formato correto e tente novamente")
    @Column(nullable = false, unique = true, length = 20 , name = "nmrCpf")
    private String cpf;

    @NotBlank(message = "O campo telefone é obrigatório")
    @Column(nullable = false, length = 25 , name = "nmrPhone")
    private String phone;

    @NotNull(message = "O campo status é obrigatório")
    @Column(nullable = false)
    private boolean active;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;

    public Client() {
    }

    public Client(Long codClient, String nmClient, String nmrPhone, boolean active, String nmrCpf, Date createdAt) {
        this.id = codClient;
        this.name = nmClient;
        this.phone = nmrPhone;
        this.active = active;
        this.cpf = nmrCpf;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
