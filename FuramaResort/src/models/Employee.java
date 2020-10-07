package models;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {
    private String nameEmployee;
    private Date dateOfBirth;
    private int identityCardNumber;
    private int numberOfPhone;
    private String Email;
    private String academicLevel;
    private String location;
    private BigDecimal salary;

    public Employee(String nameEmployee, Date dateOfBirth, int identityCardNumber, int numberOfPhone, String email, String academicLevel, String location, BigDecimal salary) {
        this.nameEmployee = nameEmployee;
        this.dateOfBirth = dateOfBirth;
        this.identityCardNumber = identityCardNumber;
        this.numberOfPhone = numberOfPhone;
        Email = email;
        this.academicLevel = academicLevel;
        this.location = location;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(int identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public int getNumberOfPhone() {
        return numberOfPhone;
    }

    public void setNumberOfPhone(int numberOfPhone) {
        this.numberOfPhone = numberOfPhone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "nameEmployee='" + nameEmployee + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", identityCardNumber=" + identityCardNumber +
                ", numberOfPhone=" + numberOfPhone +
                ", Email='" + Email + '\'' +
                ", academicLevel='" + academicLevel + '\'' +
                ", location='" + location + '\'' +
                ", salary=" + salary +
                '}';
    }


}
