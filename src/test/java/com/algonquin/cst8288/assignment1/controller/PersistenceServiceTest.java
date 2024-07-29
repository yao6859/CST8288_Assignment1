/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment1.controller;

import com.algonquin.cst8288.assignment1.emoloyee.Employee;

import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import org.junit.Before;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import com.algonquin.cst8288.assignment1.persistence.JSONFormatter;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Test class for PersistenceService
 * 
 * @author yao yi
 */
// Use MockitoJUnitRunner to run the test with Mockito support
@RunWith(MockitoJUnitRunner.class)
public class PersistenceServiceTest {
    
    // Create a mock instance of JSONFormatter
    @Mock
    private JSONFormatter jsonFormatter;
    
    //Create a temporary folder to save data
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    // Initialize a persistenceService instance
    PersistenceService persistenceService;
    
    // Create an employee instance
    private Employee employee;
    
    // Define a variable to use in setUp and tearDown
    private AutoCloseable closeable;
    
   // setUP
    @Before
    public void setUp() {
        closeable = MockitoAnnotations.openMocks (this);
        persistenceService = new PersistenceService(jsonFormatter);
    }
    
    // tearDown
    @After
    public void tearDown() throws Exception{
        closeable.close();
        persistenceService = null;
        jsonFormatter = null;
    }

    // Test the saveEmployee method 
    @Test
    public void testSaveEmployee() throws IOException {
        System.out.println("saveEmployee");
        String expectedResult = "{\"name\":\"Charlie Brown\", \"email\":\"charlie@gmail.com\"}";
        when(jsonFormatter.format(employee)).thenReturn(expectedResult);

        // Create a temporary file to store data
        File tempFile = folder.newFile("employee_data.txt");

        // Utilize the saveEmployee method and test
        persistenceService.saveEmployee(employee, tempFile.getAbsolutePath(), true);
        String fileContent = new String(Files.readAllBytes(tempFile.toPath()), StandardCharsets.UTF_8);
        assertTrue("The actual result failed to match the expect result", fileContent.contains(expectedResult));
    }
    
}