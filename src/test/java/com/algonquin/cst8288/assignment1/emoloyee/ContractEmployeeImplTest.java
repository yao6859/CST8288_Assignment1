/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment1.emoloyee;

//import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for ContractEmployeeImpl
 * 
 * @author yao yi
 */
public class ContractEmployeeImplTest {
    
    // Construct a contractEmployee object 
    ContractEmployeeImpl contractEmployee = new ContractEmployeeImpl();
    
    @Before
    public void setUp() {
        contractEmployee.setName("Sally Brown");
        contractEmployee.setEmail("sally@hotmail.com");
	contractEmployee.setAddress("188 Baseline, Ottawa, ON, K4S7C3");
        contractEmployee.setSalary(50000.0);
        contractEmployee.setNumberOfServiceYear(2);
        contractEmployee.setTotalCompensation();
        contractEmployee.setRenewalDate();
    }
   
    @After
    public void tearDown() {
        contractEmployee = null;
    }

    // Test the getRenewalDate method
    @Test
    public void testSetRenewalDateAndGetRenewalDate() {
        System.out.println("getRenewalDate");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);

        Date expResult = calendar.getTime();
        Date result = contractEmployee.getRenewalDate();

        boolean diff = Math.abs(expResult.getTime() - result.getTime()) <= 1000;
        assertTrue("The date failed to match expected result", diff);
    }

    // Test the setTotalCompensation method
    @Test
    public void testSetTotalCompensation() {
        System.out.println("setTotalCompensation");
        double expResult = contractEmployee.getTotalCompensation();
        double result = contractEmployee.calculateTotalCompensation(contractEmployee);
        assertEquals("The actual result failed to match the expected result", expResult, result, 0.001);
    }

    //Test the calculateTotalCompensation method   
    @Test
    public void testCalculateTotalCompensation() {
        System.out.println("calculateTotalCompensation");
        double expResult = contractEmployee.getSalary();
        double result = contractEmployee.calculateTotalCompensation(contractEmployee);
        assertEquals("The actual result failed to match the expected result", expResult, result, 0.001);
    }

    //Test the renewalDate method
    @Test
    public void testRenewalDate() {
        System.out.println("renewalDate");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);

        Date expResult = calendar.getTime();
        Date result = contractEmployee.renewalDate();

        boolean diff = Math.abs(expResult.getTime() - result.getTime()) <= 1000;
        assertTrue("The date failed to match expected result", diff);
    }

    /**
     * Test of toString method, of class ContractEmployeeImpl.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        contractEmployee.setRenewalDate();
        String expResult = "Employee [name=Sally Brown, email=sally@hotmail.com, " + 
                "address=188 Baseline, Ottawa, ON, K4S7C3, salary=50000.0, " + 
                "numberOfServiceYear=2, totalCompensation=50000.0, " + "renewalDate=" + contractEmployee.getRenewalDate() + "]";
        String result = contractEmployee.toString();
        assertEquals("The actual result failed to match the expected result", expResult, result); 
    }
    
}