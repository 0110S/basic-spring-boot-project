package com.example.Sp1.Service;

import com.example.Sp1.Entity.Department;
import com.example.Sp1.Repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
   @BeforeEach
//    @BeforeAll
    void setUp() {
       Department department= Department.builder()
               .departmentName("IT")
               .departmentAddress("IT-CEZ")
               .departmentCode("06")
               .departmentId(1L)
               .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }
    @Test
    @DisplayName("Get the name ")
    //@Disabled to disable this particular method
    public void whenValidDepartmentName_thenDepartmentShouldFound (){
        String departmentName="IT";
        Department found=departmentService.fetchDepartmentByName(departmentName);
        assertEquals (departmentName,found.getDepartmentName());



    }
}