package com.crio.registration.service;

import com.crio.registration.entity.Exam;
import com.crio.registration.entity.Student;
import com.crio.registration.exceptions.ExamNotFoundException;
import com.crio.registration.exceptions.StudentNotFoundException;
import com.crio.registration.exceptions.SubjectNotFoundException;

public interface ExamService {

    Exam createExamForSubject(Long subjectId, Exam exam) throws SubjectNotFoundException;

    Exam getExamById(Long examId) throws ExamNotFoundException;

    Student registerStudentToExam(Long studentId, Long examId) throws StudentNotFoundException, ExamNotFoundException;
    
}
