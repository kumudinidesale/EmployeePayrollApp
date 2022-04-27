package com.example.employee_payrollapp.model;




import com.example.employee_payrollapp.dto.EmployeeDTO;
import lombok.Data;


import javax.persistence.*;

import java.time.LocalDate;

import java.util.List;

@Entity
@Data
@Table (name="emploteeData")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Integer id;
@Column(name = "firstName")
    private String firstName;
    private String lastName;
    private String profilePic;

    private Long salary;
    private LocalDate Date;
    private String notes;

    private String gender;
@ElementCollection
@CollectionTable( name ="employee_department",joinColumns = @JoinColumn(name ="id"))
@Column(name = "department")
    private List<String> department;
    public Employee() {

        super();
    }

    public Employee(EmployeeDTO employee) {

        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.profilePic = employee.getProfilePic();
        this.department = employee.getDepartment();
        this.salary = employee.getSalary();
        this.Date = employee.getDate();
        this.notes = employee.getNotes();
        this.gender = employee.getGender();
    }

    public Employee(Integer id, EmployeeDTO employeeDTO) {
        this.id = id;
        this.firstName = employeeDTO.getFirstName();
        this.lastName = employeeDTO.getLastName();
        this.profilePic = employeeDTO.getProfilePic();
        this.department = employeeDTO.getDepartment();
        this.salary = employeeDTO.getSalary();
        this.Date = employeeDTO.getDate();
        this.notes = employeeDTO.getNotes();
        this.gender = employeeDTO.getGender();
    }



}