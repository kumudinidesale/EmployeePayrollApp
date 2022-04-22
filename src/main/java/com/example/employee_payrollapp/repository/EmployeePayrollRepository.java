package com.example.employee_payrollapp.repository;


import com.example.employee_payrollapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<User, Integer> {
}