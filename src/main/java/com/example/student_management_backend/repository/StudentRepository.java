package com.example.student_management_backend.repository;

import com.example.student_management_backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository
        extends JpaRepository<Student, Long> {

    boolean existsByEmail(String email);
}