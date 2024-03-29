package com.crio.registration.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
        name = "student-exam-map",
        joinColumns = @JoinColumn(
            name = "student_id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "exam_id"
        )
    )
    private Set<Exam> exams = new HashSet<>();

    
    @ManyToMany
    @JoinTable(
        name = "subject-student-map",
        joinColumns = @JoinColumn(
            name = "student_id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "subject_id"
        )
    )
    private Set<Subject> subjects = new HashSet<>();
}
