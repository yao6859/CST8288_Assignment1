/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment1.controller;


import com.algonquin.cst8288.assignment1.persistence.Formatter;
import com.algonquin.cst8288.assignment1.emoloyee.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class define the method to store employee data to file
 * 
 * @author yao yi
 * Course section: CST8288_033
 * Lab professor: Sazzad Hossain
 */
public class PersistenceService {
    private final Formatter formatter;
    
    // Constructor with parameter
    public PersistenceService(Formatter formatter) {
        this.formatter = formatter;
    }
    
    // The get method
    public Formatter getFormatter () {
        return formatter;
    }
    
    // Method to store data to file
    public void saveEmployee(Employee employee, String filename, boolean append) throws IOException {
        //Formatter formatter = new JSONFormatter();
	try (PrintWriter writer = new PrintWriter(new FileWriter(filename, append))) {
		writer.println(formatter.format(employee));
		writer.flush();
	}
    }
    
}