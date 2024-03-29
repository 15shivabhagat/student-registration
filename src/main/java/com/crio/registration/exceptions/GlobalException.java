package com.crio.registration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.crio.registration.entity.Error;

@RestControllerAdvice
public class GlobalException {
    
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Error> studentNotFoundException(StudentNotFoundException ex) {
        Error error = new Error(ex.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(SubjectNotFoundException.class)
    public ResponseEntity<Error> subjectNotFoundException(SubjectNotFoundException ex) {
        Error error = new Error(ex.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ExamNotFoundException.class)
    public ResponseEntity<Error> examNotFoundException(ExamNotFoundException ex) {
        Error error = new Error(ex.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
