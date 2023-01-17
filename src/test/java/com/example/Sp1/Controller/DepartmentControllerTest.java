package com.example.Sp1.Controller;

import com.example.Sp1.Entity.Department;

import com.example.Sp1.Service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

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
        department= Department.builder()
                .departmentAddress("IT-CEZ")
                .departmentCode("06")
                .departmentName("Sanjay")
                .departmentId(1L)
                .build();

    }

    @Test
    void saveDepartment() throws Exception {
       Department inputDepartment= Department.builder()
                .departmentAddress("IT-CEZ")
                .departmentCode("06")
                .departmentName("Sanjay")
                .departmentId(1L)
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);
        mockMvc.perform(post("/Departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                        \t"departmentName":"Sanjay",
                        \t"departmentAddress":"IT-CEZ",
                        \t"departmentCode":"06"
                        }"""))
                .andExpect(status().isOk());

    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/Departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                .value(department.getDepartmentName()));

    }
}
