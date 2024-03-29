package com.crio.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.registration.entity.Student;
import com.crio.registration.exceptions.StudentNotFoundException;
import com.crio.registration.exceptions.SubjectNotFoundException;
import com.crio.registration.service.StudentSubjectService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StudentSubjectController {

    @Autowired
    private StudentSubjectService studentSubjectService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentSubjectService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student newStudent = studentSubjectService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }

    @PutMapping("/students/{studentId}/subjects/{subjectId}")
    public ResponseEntity<Student> assignSubjectToStudent(@PathVariable("studentId") Long studentId,
            @PathVariable("subjectId") Long subjectId) throws SubjectNotFoundException, StudentNotFoundException {
        Student student = studentSubjectService.registerStudentToSubject(studentId, subjectId);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getAllStudents(@PathVariable("id") Long studentId) throws StudentNotFoundException {
        Student student = studentSubjectService.getStudentById(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable("id") Long studentId, @RequestBody Student student)
            throws StudentNotFoundException {
        Student updatedStudent = studentSubjectService.updateStudentById(studentId, student);
        return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
    }
}
