package com.jdn.backend.repository;

import com.jdn.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByCode(String code);
    List<Student> findByProgramId(String programId);
}
