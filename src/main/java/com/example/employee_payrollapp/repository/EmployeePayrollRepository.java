package com.example.employee_payrollapp.repository;



import com.example.employee_payrollapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeePayrollRepository extends JpaRepository<Employee, Integer> {
    @Query(value="select * from employee ,employee_department where employee.id=employee_department.id and department= :department",nativeQuery=true)
    List<Employee> findByDepartment(String department);
}