package com.technosdev.repositories;

import com.technosdev.entities.EmployeeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeServiceRepository extends JpaRepository<EmployeeService, Long> {
}
