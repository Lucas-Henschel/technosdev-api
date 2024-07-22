package com.technosdev.repositories;

import com.technosdev.entities.SchedulingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulingStatusRepository extends JpaRepository<SchedulingStatus, Long> {
}
