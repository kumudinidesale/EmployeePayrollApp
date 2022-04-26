package com.example.employee_payrollapp.dto;

import lombok.Data;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
@Data

public class EmployeeDTO {
    @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee firstName is Invalid")
    private String firstName;

    @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee lastName is Invalid")
    private String lastName;

    @NotEmpty(message = "ProfilePic cannot be null")
    private String profilePic;

    @NotEmpty(message = "Department name cannot be null")
    private String department;

    @Min(value = 500, message = "Salary should be more than 500")
    private Long salary;

    @Pattern(regexp = "female|male ", message = "Gender needs to be male or female")
    private String gender;

    @PastOrPresent(message = "Date should be past or today date")
    private LocalDate date;
    private String notes;

    public EmployeeDTO() {
        super();
    }



}
