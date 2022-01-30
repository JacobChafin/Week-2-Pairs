package com.techelevator;

public class Employee {
    long employeeId;
    String firstName;
    String lastName;
    String email;
    double salary;
    Department department;
    String hiredDate;

    public Employee(long employeeId, String firstName, String lastName, String email, Department department,String hiredDate) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.hiredDate = hiredDate;
    }

    public Employee() {
    }

    public String getFullName(String firstName, String lastName) {
        String employeeFullName = lastName + ", "+ firstName;
        return employeeFullName;
    }
    public void raiseSalary(double percent) {
        salary = startingSalary * ((100+percent)/100);
    }

    public static double startingSalary = 60000;

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail( String email) {
        this.email = email;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public void setHiredDate(String hiredDate) {
        this.hiredDate = hiredDate;
    }

    public long getEmployeeId() {
        return employeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public double getSalary() {
        return  salary;
    }
    public String getHiredDate() {
        return hiredDate;
    }
    public Department getDepartment() {
        return department;
    }
}
