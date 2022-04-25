package com.example.employee_payrollapp.Controller;


import com.example.employee_payrollapp.dto.EmployeeDTO;
import com.example.employee_payrollapp.dto.ResponseDTO;
import com.example.employee_payrollapp.model.Employee;
import com.example.employee_payrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping( "/employeePayrollService")
public class EmployeePayrollController {
    @Autowired
    IEmployeePayrollService service;


    @RequestMapping(value={"","/","/get"})
    public ResponseEntity<Employee>getContactData() {
        List<Employee> employeesList = service.getEmployee();
        ResponseDTO responseDTO = new ResponseDTO("Get call success",employeesList);
        Object employeeDTO = null;

        return new ResponseEntity(employeeDTO, HttpStatus.OK);
    }

    //Ability to save employee details to repository
    @PostMapping("/create")
    public ResponseEntity<Employee> saveDataToRepo(@RequestBody EmployeeDTO employee) {
        return new ResponseEntity<Employee>(service.postDataToRepo(employee), HttpStatus.OK);
    }

    //Ability to get all employees' data by findAll() method
    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getAllDataFromRepo() {
        return new ResponseEntity<List<Employee>>(service.getAllData(), HttpStatus.OK);
    }

    //Ability to get employee data by id
    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getDataFromRepoById(@PathVariable Integer id) {
        Optional<Employee> employee = service.getDataById(id);

        ResponseDTO dto = new ResponseDTO("Data",employee);
        return new ResponseEntity(dto, HttpStatus.OK);
    }


    //Ability to update employee data for particular id
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDataInRepo(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = service.updateDataById(id, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updating Employee PayrollData Successfuly:", employee);
        return new ResponseEntity(employeeDTO, HttpStatus.OK);
    }

    //Ability to delete employee data for particular id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDataInRepo(@PathVariable Integer id) {
        return new ResponseEntity<String>(service.deleteDataById(id), HttpStatus.OK);
    }
}
