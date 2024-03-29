package com.crio.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.registration.entity.Student;
import com.crio.registration.exceptions.ExamNotFoundException;
import com.crio.registration.exceptions.StudentNotFoundException;
import com.crio.registration.service.ExamService;

@RestController
public class ExamStudentController {
    @Autowired
    private ExamService examService;

    @PutMapping("/student/{studentId}/exams/{examId}")
    public ResponseEntity<Student> registerStudentToExam(@PathVariable("studentId") Long studentId,
            @PathVariable("examId") Long examId) throws StudentNotFoundException, ExamNotFoundException {
        Student student = examService.registerStudentToExam(studentId, examId);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }
}
