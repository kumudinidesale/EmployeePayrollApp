package com.example.employee_payrollapp.service;




import com.example.employee_payrollapp.model.User;
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

    public User postMessage(User employee) {

        return repository.save(employee);
    }

    public String putMessage(String name) {
        return "Hi-iii , " + name;
    }

    public String getWelcome() {
        return "Welcome to Employee Payroll App.....!";
    }

    @Override
    public User postDataToRepo(User employee) {
        repository.save(employee);
        return employee;
    }

    @Override
    public List<User> getAllData() {
        List<User> list = repository.findAll();
        return list;
    }

    @Override
    public Optional<User> getDataById(Integer id) {
        Optional<User> newEmployee = repository.findById(id);
        return newEmployee;
    }

    public User updateDataById(Integer id, User employee) {
        User newEmployee = new User(id, employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary(), employee.getDate());
        repository.save(newEmployee);
        return newEmployee;
    }
}