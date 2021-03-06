package com.example.employee_payrollapp.service;


import com.example.employee_payrollapp.Exception.EmployeePayrollException;
import com.example.employee_payrollapp.dto.EmployeeDTO;
import com.example.employee_payrollapp.model.Employee;
import com.example.employee_payrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    @Autowired
    EmployeePayrollRepository repository;

    public String getMessage(String name) {
        return "Welcome To Employee Program " + name;
    }

//    public String postMessage(EmployeeDTO employee) {
//        return "Hello Employee " + employee.getFirstName() + "" + employee.getLastName() + "!";
//    }

    public String putMessage(String name) {
        return "Hey Dude , " + name;
    }

    public String getWelcome() {
        return "Welcome to Employee Payroll App.....!";
    }

    @Override
    public Employee postDataToRepo(EmployeeDTO employee) {
        Employee newEmployee = new Employee(employee);
        repository.save(newEmployee);
        return newEmployee;
    }

    @Override
    public List<Employee> getAllData() {
        List<Employee> list = repository.findAll();
        return list;
    }

    @Override
    public Employee getDataById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeePayrollException("Employee with EmployeeId " + id
                        + " Doesn't Exists...!"));
    }


    public Employee updateDataById(Integer id, EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee(id, employeeDTO);
        repository.save(newEmployee);
        return newEmployee;
    }

    /*public Employee updateDataById(Integer id, EmployeeDTO employee) {
        Employee employee = this.getDataById(id);
        employee.updateDataById(employee);
        return repository.save(employee);*/




    public String deleteDataById(Integer id) {
        repository.deleteById(id);
        return "Employee with unique ID:" + id + " got deleted";
    }

    @Override
    public List<Employee> getDataByDepartment(String department) {
        return repository.findByDepartment(department);
    }


}