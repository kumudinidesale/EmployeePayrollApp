package com.example.employee_payrollapp.service;



import com.example.employee_payrollapp.model.User;
import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    public String getMessage(String name) {
        return "Welcome "+name;
    }

    public String postMessage(User employee) {
        return "Hello "+employee.getFirstName()+""+employee.getLastName()+"!";
    }

    public String putMessage(String name) {
        return "How are you, "+name;
    }
}