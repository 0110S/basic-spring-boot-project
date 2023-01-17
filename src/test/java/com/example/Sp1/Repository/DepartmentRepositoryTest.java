package com.example.Sp1.Repository;

import com.example.Sp1.Entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private  DepartmentRepository  departmentRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("San")
                .departmentAddress("IT 01")
                .departmentCode("001")
                .build();
        testEntityManager.persist(department);

    }
    @Test
    public void whenFindById_returnDepartmentId () {

        Department department= departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"San");
    }


}
