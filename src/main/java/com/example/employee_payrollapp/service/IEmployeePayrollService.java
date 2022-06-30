package com.example.employee_payrollapp.service;


import com.example.employee_payrollapp.dto.EmployeeDTO;
import com.example.employee_payrollapp.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeePayrollService {
    String getMessage(String name);

//    String postMessage(EmployeeDTO employee);

    String putMessage(String name);

    String getWelcome();

    public Employee postDataToRepo(EmployeeDTO employee);

    public List<Employee> getAllData();

    public Employee getDataById(Integer id);

    public Employee updateDataById(Integer id, EmployeeDTO employeeDTO);

    public String deleteDataById(Integer id);


    public List<Employee> getDataByDepartment(String department);
}
