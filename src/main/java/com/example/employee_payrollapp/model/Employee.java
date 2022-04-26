package com.example.employee_payrollapp.model;




import com.example.employee_payrollapp.dto.EmployeeDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;
    private String lastName;
    private String profilePic;
    private String department;
    private Long salary;
    private LocalDate date;
    private String notes;

    private String gender;


    public Employee() {

        super();
    }

    public Employee(EmployeeDTO employee) {

        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.profilePic = employee.getProfilePic();
        this.department = String.valueOf(employee.getDepartment());
        this.salary = employee.getSalary();
        this.date = employee.getDate();
        this.notes = employee.getNotes();
        this.gender = employee.getGender();
    }

    public Employee(Integer id, EmployeeDTO employeeDTO) {
        this.id = id;
        this.firstName = employeeDTO.getFirstName();
        this.lastName = employeeDTO.getLastName();
        this.profilePic = employeeDTO.getProfilePic();
        this.department = String.valueOf(employeeDTO.getDepartment());
        this.salary = employeeDTO.getSalary();
        this.date = employeeDTO.getDate();
        this.notes = employeeDTO.getNotes();
        this.gender = employeeDTO.getGender();
    }


}