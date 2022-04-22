package com.example.employee_payrollapp.service;


import com.example.employee_payrollapp.model.User;

import java.util.List;
import java.util.Optional;


public interface IEmployeePayrollService {

    public String getMessage(String name) ;
    public User postMessage(User employee);
    public String putMessage(String name) ;

    String getWelcome();

    User postDataToRepo(User employee);

    List<User> getAllData();

    Optional<User> getDataById(Integer id);

    User updateDataById(Integer id, User employee);
}
