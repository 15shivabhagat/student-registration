package com.crio.registration.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.crio.registration.entity.Student;
import com.crio.registration.exceptions.StudentNotFoundException;
import com.crio.registration.service.StudentSubjectService;

@WebMvcTest(StudentSubjectController.class)
public class StudentSubjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentSubjectService studentSubjectService;

    private Student response;

    @BeforeEach
    void setUp() {
        response = Student.builder()
                        .id(1L)
                        .name("Test")
                        .exams(null)
                        .subjects(null)
                        .build(); 
    }

    @Test
    void testGetStudentById_successResponse() throws Exception {
        Mockito.when(studentSubjectService.getStudentById(1L)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/students/1"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
    }

    @Test
    void testGetStudentById_errorResponse() throws Exception {
        Mockito.when(studentSubjectService.getStudentById(1L)).thenThrow(new StudentNotFoundException("Student not found"));

        mockMvc.perform(MockMvcRequestBuilders.get("/students/1"))
            .andExpect(MockMvcResultMatchers.status().isNotFound())
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").exists());
    }
}
