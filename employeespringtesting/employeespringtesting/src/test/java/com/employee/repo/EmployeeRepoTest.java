package com.employee.repo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepoTest {
@Autowired
    EmployeeRepo employeeRepo;
    Employee employee;
    @BeforeEach
    void setUp() {
employee= new Employee("abc","abc",new BigDecimal(1000));

    }
@Test

public void givenEmployee_whenSave_thenReturnEmployee(){
        Employee e1= new Employee("abc","abc",new BigDecimal(1000));
        employeeRepo.save(e1);
        assertNotNull(e1);
}
@Test
public void givenEmployee_whenFindById_thenReturnEmployee(){
    Employee e1= new Employee("abc","abc",new BigDecimal(1000));
    employeeRepo.save(e1);
    int employeeId=e1.getId();
    assertEquals(employeeId,employeeRepo.findById(employeeId).get().getId());
}
@Test
public void givenEmployee_whenDelete_thenReturnEmployee(){
    Employee e1= new Employee("abc","abc",new BigDecimal(1000));
    employeeRepo.save(e1);
    int employeeId=e1.getId();
    employeeRepo.deleteById(employeeId);
    Optional optional=employeeRepo.findById(employeeId);
    assertFalse(optional.isPresent());
}
    @AfterEach
    void tearDown() {
        employee = null;
    }


}