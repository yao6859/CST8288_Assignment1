/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment1.emoloyee;

import static com.algonquin.cst8288.assignment1.controller.Rate.BONUS_PERCENTAGE;
import static com.algonquin.cst8288.assignment1.controller.Rate.PENSION_PERCENTAGE;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for PermanentEmployeeImpl
 * 
 * @author yao yi
 */
public class PermanentEmployeeImplTest {
    

    // Construct a permanentEmployee object 
    PermanentEmployeeImpl permanentEmployee = new PermanentEmployeeImpl();
    
    // setUP
    @Before
    public void setUp() {        
        permanentEmployee.setName("Charlie Brown");
        permanentEmployee.setEmail("charlie@gmail.com");
        permanentEmployee.setAddress("11 Majestic, Ottawa, ON, K1G1A5");
        permanentEmployee.setSalary(80000.0);
        permanentEmployee.setNumberOfServiceYear(5);
    }
    
    // tearDown
    @After
    public void tearDown() {
        permanentEmployee = null;
    }

    // Test the getBonus method  
    @Test
    public void testSetBonusAndGetBonus() {
        System.out.println("getBonus:");
        permanentEmployee.setBonus(permanentEmployee);
        double expResult = 80000.0 * BONUS_PERCENTAGE * permanentEmployee.getNumberOfServiceYear();
        double result = permanentEmployee.getBonus();
        assertEquals("The actual result failed to match the expected result", expResult, result, 0.001);
    }

    // Test the getPension method  
    @Test
    public void testSetPensionAndGetPension() {
        System.out.println("getPension:");
        permanentEmployee.setPension(permanentEmployee);
        double expResult = permanentEmployee.getSalary() * PENSION_PERCENTAGE;
        double result = permanentEmployee.getPension();
        assertEquals("The actual result failed to match the expected result", expResult, result, 0.001);
    }

    // Test the setTotalCompensation method    
    @Test
    public void testSetTotalCompensation() {
        System.out.println("setTotalCompensation");
        permanentEmployee.setTotalCompensation();
        double expResult = permanentEmployee.getTotalCompensation();
        double result = permanentEmployee.calculateTotalCompensation(permanentEmployee);
        assertEquals("The actual result failed to match the expected result", expResult, result, 0.001);
    }

    // Test the calculateTotalCompensation method  
    @Test
    public void testCalculateTotalCompensation() {
        System.out.println("calculateTotalCompensation");
        permanentEmployee.setBonus(permanentEmployee);
        double expResult = permanentEmployee.getSalary() + permanentEmployee.getBonus();
        double result = permanentEmployee.calculateTotalCompensation(permanentEmployee);
        assertEquals("The actual result failed to match the expected result", expResult, result, 0.001);
    }

    // Test the calculateBonus method  
    @Test
    public void testCalculateBonus() {
        System.out.println("calculateBonus");
        permanentEmployee.setBonus(permanentEmployee);
        double expResult = permanentEmployee.getBonus();
        double result = permanentEmployee.calculateBonus(permanentEmployee);
        assertEquals("The actual result failed to match the expected result", expResult, result, 0.001);
    }

    //Test the pensionContribution method 
    @Test
    public void testPensionContribution() {
        System.out.println("pensionContribution");
        permanentEmployee.setPension(permanentEmployee);
        double expResult = permanentEmployee.getPension();
        double result = permanentEmployee.pensionContribution(permanentEmployee);
        assertEquals("The actual result failed to match the expected result", expResult, result, 0.001);
    }

    // Test the toString method
    @Test
    public void testToString() {
        System.out.println("toString");
        permanentEmployee.setPension(permanentEmployee);
        permanentEmployee.setBonus(permanentEmployee);
        permanentEmployee.setTotalCompensation();
        String expResult = "Employee [name=Charlie Brown, email=charlie@gmail.com, " +
                "address=11 Majestic, Ottawa, ON, K1G1A5, salary=80000.0, " +
                "numberOfServiceYear=5, totalCompensation=90000.0, bonus=10000.0, pension=800.0]";
        String result = permanentEmployee.toString();
        assertEquals(expResult, result);    
    }
    
}