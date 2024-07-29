package com.algonquin.cst8288.assignment1.controller;

import com.algonquin.cst8288.assignment1.emoloyee.ContractEmployeeImpl;
import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import com.algonquin.cst8288.assignment1.emoloyee.PermanentEmployeeImpl;
import com.algonquin.cst8288.assignment1.persistence.Formatter;
import com.algonquin.cst8288.assignment1.persistence.JSONFormatter;
import com.algonquin.cst8288.assignment1.persistence.TextFormatter;

import java.io.IOException;

/**
 * 
 * Main class to execute the application
 * 
 * @author yao yi
 * Course section: CST8288_033
 * Lab professor: Sazzad Hossain
 */

public class Main {
	
	public static void main(String[] args) throws IOException {
            // Instantiate two Employee objects
            Employee permanentEmployee = new PermanentEmployeeImpl();
            Employee contractEmployee = new ContractEmployeeImpl();

            // Use PermanentEmployeeImpl to calculate and populate data for permanentEmployee
            // Cast the object type to PermanentEmployee
            PermanentEmployeeImpl permanentEmployeeImpl = (PermanentEmployeeImpl) permanentEmployee;
            permanentEmployeeImpl.setName("CharlieBrown");
            permanentEmployeeImpl.setEmail("charlie@gmail.com");
            permanentEmployeeImpl.setAddress("11 Majestic, Ottawa, ON, K1G1A5");
            permanentEmployeeImpl.setSalary(80000.0);
            permanentEmployeeImpl.setNumberOfServiceYear(5);
            permanentEmployeeImpl.setTotalCompensation();
            permanentEmployeeImpl.setBonus(permanentEmployee);
            permanentEmployeeImpl.setPension(permanentEmployee);
     

            // Use ContractEmployeeImpl to calculate and populate data for contractEmployee
            // Cast the object type to ContractEmployee
            ContractEmployeeImpl contractEmployeeImpl = (ContractEmployeeImpl) contractEmployee;
            contractEmployeeImpl.setName("SallyBrown");
            contractEmployeeImpl.setEmail("sally@hotmail.com");
            contractEmployeeImpl.setAddress("188 Baseline, Ottawa, ON, K4S7C3");
            contractEmployeeImpl.setSalary(50000.0);
            contractEmployeeImpl.setNumberOfServiceYear(2);
            contractEmployeeImpl.setTotalCompensation();
            contractEmployeeImpl.setRenewalDate();
            

            // Utilize EmployeeController.java to save both objects in JSON and Text formats, 
            //saving the data in files named json_employee_data.txt and text_employee_data.txt
            EmployeeValidator validator = new EmployeeValidator();
            Formatter textFormatter = new TextFormatter();
            Formatter jsonFormatter = new JSONFormatter();
            PersistenceService textPersistenceService = new PersistenceService(textFormatter);
            PersistenceService jsonPersistenceService = new PersistenceService(jsonFormatter);
            EmployeeController textController = new EmployeeController(validator, textPersistenceService);
            EmployeeController jsonController = new EmployeeController(validator, jsonPersistenceService);
            
            try {
                // Set the new entries of contract employee append to the permanent employee, not overwrite them
                boolean append = true;
                // Save permanentEmployee's data in JSON format
                jsonController.processEmployee(permanentEmployee, "json_employee_data.txt", !append);
                // Save contractEmployee's data in JSON format
                jsonController.processEmployee(contractEmployee, "json_employee_data.txt", append);
                // Save permanentEmployee's data in Text format
                textController.processEmployee(permanentEmployee, "text_employee_data.txt", !append);
                // Save contractEmployee's data in Text format
                textController.processEmployee(contractEmployee, "text_employee_data.txt", append);
                
                // Print permanentEmployee's data  in JSON format
                System.out.println("\nPermanent employee's data in JSON format: ");
                jsonController.printEmployee(permanentEmployee);
                // Print contractEmployee's data in JSON format
                System.out.println("\nContract employee's data in JSON format: ");
                jsonController.printEmployee(contractEmployee);
                // Print permanentEmployee's data in Text format
                System.out.println("\nPermanent employee's data in Text format: ");
                textController.printEmployee(permanentEmployee);
                // Print contractEmployee's data in Text format
                System.out.println("\nContract employee's data in Text format: ");
                textController.printEmployee(contractEmployee);               
            } catch (IOException e) {
            }
        }
}
