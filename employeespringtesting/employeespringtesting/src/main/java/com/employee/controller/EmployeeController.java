package com.employee.controller;

import com.employee.repo.Employee;
import com.employee.services.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
//@RequestMapping("api")
public class EmployeeController {
    public static final Logger logger = Logger.getLogger(EmployeeController.class.getName());
    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @Operation(summary = "Get all employees")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("employees")
    public ResponseEntity<List<Employee>> getEmployees(){
    logger.info("Getting all employees");
        return ResponseEntity.status(HttpStatus.OK).body(service.getEmployees());
    }

    @GetMapping("employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        logger.info("Getting employee with id: "+id);
        return ResponseEntity.status(HttpStatus.OK).body(service.getEmployeeById(id));
    }
    @Operation(summary = "Add employee")
    @ApiResponse(responseCode = "201", description = "Created")
    @PostMapping("employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addEmployee(employee));
    }

    @PutMapping("employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateEmployee(id, employee));
    }
    @DeleteMapping("employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){
        service.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }



}
