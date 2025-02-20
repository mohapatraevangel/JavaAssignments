package com.employee.controller;

import com.employee.repo.Employee;
import com.employee.repo.EmployeeRepo;
import com.employee.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class)
class EmployeeControllerTest {
@Autowired
private MockMvc mockMvc;

@MockBean
private EmployeeService employeeService;

@MockBean
private EmployeeRepo employeeRepo;

@Autowired
private ObjectMapper objectMapper;


    @Test
    public void givenEmployeeObject_whenCreateEmployee_thenReturnEmployee() throws Exception {
        Employee e = new Employee("Maria", "EEE", new BigDecimal(1000));
        given(employeeService.addEmployee(any(Employee.class))).willAnswer((invocation) -> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).
                content(objectMapper.writeValueAsString(e)));

response.andDo(print()).andExpect(status().isCreated()).andExpect(jsonPath("$.name",is(e.getName())))
        .andExpect(jsonPath("$.dept",is(e.getDept())))
        .andExpect(jsonPath("$.salary",is(e.getSalary().intValue())));





    }

    @Test
    public void givenListOfEmployees_whenGetAllEmployees_thenReturnListOfEmployees () throws Exception {
    List<Employee> list = new ArrayList<>();
    list.add(Employee.builder().name("Maria").dept("EEE").salary(new BigDecimal(1000)).build());
    given(employeeService.getEmployees()).willReturn(list);

    ResultActions response = mockMvc.perform(get("/employees"));

    response.andExpect(status().isOk())
            .andDo(print())
            .andExpect(jsonPath("$.size()", is(list.size())));

    }


}