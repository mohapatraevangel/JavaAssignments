package com.employee.integration;

import com.employee.repo.Employee;
import com.employee.repo.EmployeeRepo;
import com.employee.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmployeeAppIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        employeeRepo.deleteAll();
    }

    @Test
    public void givenEmployee_whenCreateEmployee_thenReturnEmployee() throws Exception {
        Employee employee = Employee.builder()
                .name("abc")
                .dept("abc")
                .salary(new BigDecimal(1000))
                .build();

        // Serialize the employee object to JSON string
        String employeeJson = objectMapper.writeValueAsString(employee);

        // Perform the POST request with the serialized employee JSON
        ResultActions response = mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeJson))  // Pass the employeeJson as the content
                .andExpect(status().isCreated());

        // Assert that the response matches the expected values
        response.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(employee.getName())))
                .andExpect(jsonPath("$.dept", is(employee.getDept())))
                .andExpect(jsonPath("$.salary", is(employee.getSalary().intValue())));
    }
}
