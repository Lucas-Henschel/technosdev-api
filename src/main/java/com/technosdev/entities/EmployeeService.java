package com.technosdev.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table
public class EmployeeService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cod_service")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "cod_empl")
    private Employee employee;

    public EmployeeService() {
    }

    public EmployeeService(Long codService, Service service, Long codEmployee, Employee employee) {
        this.service = service;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
