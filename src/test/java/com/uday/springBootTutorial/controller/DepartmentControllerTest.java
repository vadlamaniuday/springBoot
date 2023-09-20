package com.uday.springBootTutorial.controller;

import com.uday.springBootTutorial.entity.Department;
import com.uday.springBootTutorial.error.DepartmentNotFoundException;
import com.uday.springBootTutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;


    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentAddress("Bangalore")
                .departmentCode("BCA-76")
                .departmentCode("Bachelor of Computer Applications")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentAddress("Bangalore")
                .departmentCode("BCA-76")
                .departmentCode("Bachelor of Computer Applications")
                .build();


        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);


        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("" +
                "{\n" +
                "    \"departmentName\":\"Bachelor of Computer Applications\",\n" +
                "    \"departmentAddress\":\"Bangalore\",\n" +
                "    \"departmentCode\":\"BCA-76\"\n" +
                "}")).andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentByID() throws Exception {
        Mockito.when(departmentService.fetchDepartmentByID(1L)).thenReturn(department);


        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));

    }
}