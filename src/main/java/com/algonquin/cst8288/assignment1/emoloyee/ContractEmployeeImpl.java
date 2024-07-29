
package com.algonquin.cst8288.assignment1.emoloyee;

import java.util.Calendar;
import java.util.Date;

/**
 * The concrete class for contract employee to implements interface 
 * 
 * @author yao yi
 * Course section: CST8288_033
 * Lab professor: Sazzad Hossain
 */
public class ContractEmployeeImpl extends Employee implements EmployeeService,ContractEmployeeService {
    
    private Date renewalDate;
    
    // Getters and Setters
    public Date getRenewalDate() {
        return renewalDate;
    }
    
    public void setRenewalDate() {
        this.renewalDate = renewalDate();
    }
    
    public void setTotalCompensation() {
        this.totalCompensation = calculateTotalCompensation(this);
    }
    
    // Override methods from implemented interfaces and super class
    @Override
    public double calculateTotalCompensation(Employee employee) {
        // total compensation, 
        return employee.getSalary();
    }

    @Override
    public Date renewalDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);

        return calendar.getTime();
    }
    
    @Override
    public String toString() {
        String superString = super.toString();
        int index = superString.lastIndexOf(']');
        return superString.substring(0, index) + ", renewalDate=" + renewalDate + "]";
    }

}
