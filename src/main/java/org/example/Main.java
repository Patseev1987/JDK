package org.example;


import org.example.sem4.Employee;
import org.example.sem4.EmployeesDictionary;

import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        EmployeesDictionary employees = EmployeesDictionary.getInstance();
        employees.addEmployee(new Employee(1,"3333","John",LocalDate.of(2012,12,12)));
        employees.addEmployee(new Employee(2,"3667","Franc",LocalDate.of(2020,2,1)));
        employees.addEmployee(new Employee(3,"8899","Coule",LocalDate.of(2018,3,17)));
        employees.addEmployee(new Employee(4,"000000","Bob",LocalDate.of(2021,5,26)));
        employees.addEmployee(new Employee(5,"776859403","Thomas",LocalDate.of(2009,4,7)));
        employees.showAllEmployees();

        EmployeesDictionary emp2 = EmployeesDictionary.getInstance();
        emp2.showAllEmployees();

        employees.searchPhoneNumberByName("John");
        emp2.showResultsByExperienceSearch();

        employees.showEmployeeByPersonalNumber(3);


        emp2.showEmployeeByPersonalNumber(100);


    }
}