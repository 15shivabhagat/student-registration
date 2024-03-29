package com.crio.registration.service.Implementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.registration.entity.Exam;
import com.crio.registration.entity.Student;
import com.crio.registration.entity.Subject;
import com.crio.registration.exceptions.ExamNotFoundException;
import com.crio.registration.exceptions.StudentNotFoundException;
import com.crio.registration.exceptions.SubjectNotFoundException;
import com.crio.registration.repository.ExamRepository;
import com.crio.registration.repository.StudentRepository;
import com.crio.registration.repository.SubjectRepository;
import com.crio.registration.service.ExamService;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Exam createExamForSubject(Long subjectId, Exam exam) throws SubjectNotFoundException {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new SubjectNotFoundException("Subject not found"));
        exam.setSubject(subject);
        return examRepository.save(exam);
    }

    @Override
    public Exam getExamById(Long examId) throws ExamNotFoundException {
        return examRepository.findById(examId).orElseThrow(() -> new ExamNotFoundException("Exam Not Found"));
    }

    @Override
    public Student registerStudentToExam(Long studentId, Long examId)
            throws StudentNotFoundException, ExamNotFoundException {
        Set<Exam> examSet = null;
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student Not Found"));
        Exam exam = examRepository.findById(examId).orElseThrow(() -> new ExamNotFoundException("Exam Not Found"));

        examSet = student.getExams();
        examSet.add(exam);
        student.setExams(examSet);
        return studentRepository.save(student);
    }

}
