package com.crio.registration.service.Implementation;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.registration.entity.Student;
import com.crio.registration.entity.Subject;
import com.crio.registration.exceptions.StudentNotFoundException;
import com.crio.registration.exceptions.SubjectNotFoundException;
import com.crio.registration.repository.StudentRepository;
import com.crio.registration.repository.SubjectRepository;
import com.crio.registration.service.StudentSubjectService;

@Service
public class StudentSubjectServiceImpl implements StudentSubjectService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Student registerStudentToSubject(Long studentId, Long subjectId)
            throws SubjectNotFoundException, StudentNotFoundException {
        Set<Subject> subjectsSet = null;
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student Not Found"));
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new SubjectNotFoundException("Subject Not Found"));

        subjectsSet = student.getSubjects();
        subjectsSet.add(subject);
        student.setSubjects(subjectsSet);
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long studentId) throws StudentNotFoundException {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student Not Found"));
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudentById(Long studentId, Student student) throws StudentNotFoundException {
        Student studentById = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found."));
        studentById.setName(student.getName());
        return studentRepository.save(studentById);
    }

}
