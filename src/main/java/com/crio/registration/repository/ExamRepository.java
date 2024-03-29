package com.crio.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.registration.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    
}
