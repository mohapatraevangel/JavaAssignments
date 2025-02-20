package com.employee.repo;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter
@Builder

@Entity
@Table(name = "employees") //optional

public class Employee {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "{employee.name.absent}")
    private String name;
    private String dept;
    @NotNull(message = "{employee.salary.absent}")
    @Range(min = 10, max = 100000, message = "{employee.salary.invalid}")
  //  @Column(name = "salary")
    private BigDecimal salary;

//    public Employee(int id, String name, String dept, int salary) {
//        this.id = id;
//        this.name = name;
//        this.dept = dept;
//        this.salary = salary;
//    }

    public Employee(String name, String dept, BigDecimal salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}
