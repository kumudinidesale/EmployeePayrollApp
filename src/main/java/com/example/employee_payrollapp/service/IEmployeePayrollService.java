package com.example.employee_payrollapp.service;


import com.example.employee_payrollapp.dto.EmployeeDTO;
import com.example.employee_payrollapp.model.Employee;

import java.util.List;

public interface IEmployeePayrollService {

    public String getMessage(String name) ;
    public String postMessage(EmployeeDTO employeeDTO);
    public String putMessage(String name) ;
    public String getWelcome();
    public Employee postDataToRepo(Employee employee);
    public List<Employee> getAllData();
    public Employee getDataById(Integer id);
    public Employee updateDataById(Integer id,EmployeeDTO employeeDTO);
    public String deleteDataById(Integer id);
}
