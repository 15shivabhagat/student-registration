package com.crio.registration.service;

import java.util.List;

import com.crio.registration.entity.Student;
import com.crio.registration.exceptions.StudentNotFoundException;
import com.crio.registration.exceptions.SubjectNotFoundException;

public interface StudentSubjectService {
    Student registerStudentToSubject(Long studentId, Long subjectId) throws SubjectNotFoundException, StudentNotFoundException;

    Student getStudentById(Long studentId) throws StudentNotFoundException;

    Student createStudent(Student student);

    List<Student> getAllStudents();

    Student updateStudentById(Long studentId, Student student) throws StudentNotFoundException;
}
