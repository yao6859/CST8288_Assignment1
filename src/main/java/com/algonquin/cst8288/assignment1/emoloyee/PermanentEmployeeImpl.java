
package com.algonquin.cst8288.assignment1.emoloyee;

import com.algonquin.cst8288.assignment1.controller.Rate;

/**
 * The concrete class for permanent employee to implements interface 
 * 
 * @author yao yi
 * Course section: CST8288_033
 * Lab professor: Sazzad Hossain
 */
public class PermanentEmployeeImpl extends Employee implements EmployeeService,PermanentEmployeeService {
    
    private double bonus;
    private double pension;

    //constructor
    public PermanentEmployeeImpl(){
    
    }
    
    // Getters and Setters
    public double getBonus(){
        return bonus;
    }
    
    public void setBonus(Employee employee){
        this.bonus = this.calculateBonus(employee);
    }
    
    public double getPension(){
        return pension;
    }
    
    public void setPension(Employee employee){
        this.pension = this.pensionContribution(employee);
    }
 
    public void setTotalCompensation() {
        this.totalCompensation = calculateTotalCompensation(this);
    }
    
    // Override method from implemented interfaces and superclass
    @Override
    public double calculateTotalCompensation(Employee employee) {
        // total compensation, 
        return employee.getSalary() + calculateBonus(employee);
    }

    @Override
    public double pensionContribution(Employee employee) {
        // pension contribution, 
        return employee.getSalary() * Rate.PENSION_PERCENTAGE; 
    }

    @Override
    public double calculateBonus(Employee employee) {
        // Calculate bonus, 
        return employee.getSalary() * Rate.BONUS_PERCENTAGE * employee.getNumberOfServiceYear(); 
    }
    
    // Override toString method
    @Override
    public String toString() {
        String string = super.toString();
        int index = string.lastIndexOf(']');
        return string.substring(0, index) + ", bonus=" + bonus + ", pension=" + pension + "]";
    }
    
}
