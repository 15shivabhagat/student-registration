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

import com.crio.registration.entity.Exam;
import com.crio.registration.exceptions.ExamNotFoundException;
import com.crio.registration.service.ExamService;

@WebMvcTest(ExamController.class)
public class ExamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExamService examService;

    private Exam response;
    @BeforeEach
    void setUp() {
        response = new Exam().builder()
                        .id(1L)
                        .name("Test Exam")
                        .students(null)
                        .students(null)
                        .build();
    }

    @Test
    void testGetExamById_successResponse() throws Exception {
        Mockito.when(examService.getExamById(1L)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/exams/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
    }

    @Test
    void testGetExamById_errorResponse() throws Exception {
        Mockito.when(examService.getExamById(1L)).thenThrow(new ExamNotFoundException("Exam not found"));

        mockMvc.perform(MockMvcRequestBuilders.get("/exams/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").exists());
    }
    
}
