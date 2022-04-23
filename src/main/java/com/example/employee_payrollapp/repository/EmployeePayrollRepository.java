package com.example.employee_payrollapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository<Empoyee> extends JpaRepository<Empoyee, Integer> {
}