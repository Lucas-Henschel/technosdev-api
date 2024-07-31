package com.technosdev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codEmpl")
    private Long id;

    @NotBlank(message = "O campo nome é obrigatório")
    @Size(min = 1, max = 100, message = "O nome tem que ter no máximo 100 caracteres")
    @Column(nullable = false, length = 100 , name = "nm_empl")
    private String name;

    @NotBlank(message = "O campo CPF é obrigatório")
    @CPF(message = "Formato de CPF inválido. Certifique-se de que o CPF esteja no formato correto e tente novamente")
    @Column(nullable = false, length = 20 , name = "cpf_empl")
    private String cpf;

    @NotBlank(message = "O campo telefone é obrigatório")
    @Size(min = 11 , max = 11 , message = "Número de telefone mal formatado. Verifique o formato e tente novamente.")
    @Column(nullable = false, length = 20 , name = "nmr_hone")
    private String phone;

    @NotBlank(message = "O campo email é obrigatório")
    @Email(message = "E-mail mal formatado. Exemplo de formato correto: exemplo@gmail.com.")
    @Column(nullable = false, length = 50 , name = "nm_email")
    private String email;

    @NotBlank(message = "O campo usuário é obrigatório")
    @Column(nullable = false, length = 100 , name = "company_user")
    private String user;

    @NotBlank(message = "O campo usuário é obrigatório")
    @Column(nullable = false, length = 1000 , name = "company_password")
    private String password;

    @Column(nullable = false)
    private boolean active;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false , name = "created_at")
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public Employee() {
    }

    public Employee(Long codEmpl, String nmEmpl, String cpfEmpl, String phone, String email , String user, String password , boolean active, Date createdAt) {
        this.id = codEmpl;
        this.name = nmEmpl;
        this.cpf = cpfEmpl;
        this.email = email;
        this.user = user;
        this.password = password;
        this.phone = phone;
        this.active = active;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

