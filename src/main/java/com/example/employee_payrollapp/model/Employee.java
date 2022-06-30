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

    private String name;
   
    private String profilePic;

    private Long salary;

    private String startDate;
    private String note;

    private String gender;
@ElementCollection
@CollectionTable( name ="employee_department",joinColumns = @JoinColumn(name ="id"))
@Column(name = "department")
    private List<String> departments;
    public Employee() {

        super();
    }

    public Employee(EmployeeDTO employee) {

        this.name = employee.getName();

        this.profilePic = employee.getProfilePic();
        this.departments = employee.getDepartments();
        this.salary = employee.getSalary();
        this.startDate = employee.getStartDate();
        this.note = employee.getNote();
        this.gender = employee.getGender();
    }

    public Employee(Integer id, EmployeeDTO employeeDTO) {
        this.id = id;
        this.name = employeeDTO.getName();

        this.profilePic = employeeDTO.getProfilePic();
        this.departments = employeeDTO.getDepartments();
        this.salary = employeeDTO.getSalary();
        this.startDate = employeeDTO.getStartDate();
        this.note = employeeDTO.getNote();
        this.gender = employeeDTO.getGender();
    }



}