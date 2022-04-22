package com.example.employee_payrollapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;

    private String department;
    private Long salary;
    private LocalDate date;


    public User(Integer id, String firstName, String lastName,  String department, Long salary,
                    LocalDate date) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = department;
        this.salary = salary;
        this.date = date;

    }

    public User() {
        super();
    }

    public User(User employee) {
        super();
        this.id = employee.id;
        this.firstName = employee.firstName;
        this.lastName = employee.lastName;

        this.department = employee.department;
        this.salary = employee.salary;
        this.date = employee.date;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
