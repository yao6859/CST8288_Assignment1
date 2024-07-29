package com.algonquin.cst8288.assignment1.controller;

import java.io.IOException;
import com.algonquin.cst8288.assignment1.emoloyee.Employee;

/**
 * This class is to process and save employee data
 * 
 * @author yao yi
 * Course section: CST8288_033
 * Lab professor: Sazzad Hossain
 */
public class EmployeeController {

    private final EmployeeValidator validator;
    private final PersistenceService persistenceService;

    // Constructor with two parameters
    public EmployeeController(EmployeeValidator validator,
            PersistenceService persistenceService) {
        this.validator = validator;
        this.persistenceService = persistenceService;
    }
    
    // Method to save employee's data if validated succesfully
    public String processEmployee(Employee employee, String fileName, boolean append) throws IOException {
        // Validate data
        if (!validator.isValidEmployee(employee)) {
            return "FAILED";
        }
        // Store data if successfully validated
        persistenceService.saveEmployee(employee, fileName, append);
        return "SUCCESS";
    }
    
    // Print employee's data in console
    public void printEmployee(Employee employee) throws IOException {
        System.out.println(persistenceService.getFormatter().format(employee));
    }

}