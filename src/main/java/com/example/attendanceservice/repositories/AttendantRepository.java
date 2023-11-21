package com.example.attendanceservice.repositories;

import com.example.attendanceservice.entities.Attendant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendantRepository extends JpaRepository<Attendant, Long> {
}
