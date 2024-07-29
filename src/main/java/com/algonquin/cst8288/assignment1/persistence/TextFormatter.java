/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment1.persistence;

import java.io.IOException;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;
import com.algonquin.cst8288.assignment1.emoloyee.ContractEmployeeImpl;
import com.algonquin.cst8288.assignment1.emoloyee.PermanentEmployeeImpl;

/**
 * Concrete class that implements Formatter interface to convert data into Text format
 * 
 * @author yao yi
 * Course section: CST8288_033
 * Lab professor: Sazzad Hossain
 */
public class TextFormatter implements Formatter {
    // Construct the text string by overriding format method
    @Override
    public String format(Employee employee) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("name=").append(employee.getName()).append("\n");
        sb.append("email=").append(employee.getEmail()).append("\n");
        sb.append("address=").append(employee.getAddress()).append("\n");
        sb.append("salary=").append(employee.getSalary()).append("\n");
        sb.append("numberOfServiceYear=").append(employee.getNumberOfServiceYear()).append("\n");
        sb.append("totalCompensation=").append(employee.getTotalCompensation()).append("\n");
        if (employee instanceof ContractEmployeeImpl) {
            ContractEmployeeImpl contractEmployee = (ContractEmployeeImpl) employee;
            sb.append("renewalDate=").append(contractEmployee.getRenewalDate());
        } else if (employee instanceof PermanentEmployeeImpl) {
            PermanentEmployeeImpl permanentEmployee = (PermanentEmployeeImpl) employee;
            sb.append("bonus=").append(permanentEmployee.getBonus()).append(",\n");
            sb.append("pension=").append(permanentEmployee.getPension()).append(",\n");
        }
        return sb.toString();
    }
}
