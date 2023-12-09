package org.example.sem4;

import java.util.*;

public class EmployeesDictionary {
    private static EmployeesDictionary instance;
    private final Map<Integer, Employee> EMPLOYEES = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    private EmployeesDictionary() {
    }

    public static EmployeesDictionary getInstance() {
        if (instance == null) {
            instance = new EmployeesDictionary();
        }
        return instance;
    }

    public void addEmployee(Employee employee) {
        EMPLOYEES.put(employee.getPersonalNumber(), employee);
    }

    public List<Employee> searchEmployeeByExperience() {
        List<Employee> result = new ArrayList<>();
        int experience = enteredData();
        for (var employee : EMPLOYEES.values()) {
            if (employee.getWorkExperience() >= experience) {
                result.add(employee);
            }
        }
        return result;
    }

    private int enteredData() {
        System.out.println("Enter the experience in months:");
        int result = -1;
        try {
            result = scanner.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("You entered wrong data");
        }
        return result;
    }


    private void showResult(List<Employee> employees) {
        for (var employee : employees) {
            System.out.println(employee);
        }
    }

    public void showResultsByExperienceSearch() {
        showResult(searchEmployeeByExperience());
    }

    public void searchPhoneNumberByName(String name) {
        for (var employee : EMPLOYEES.values()) {
            if (employee.getName().equals(name)) {
                System.out.println(employee.getName() + " - " + employee.getPhoneNumber());
            }
        }
    }

    public Employee searchEmployeeByPersonalNumber(int personalNumber) {
        return EMPLOYEES.get(personalNumber);
    }

    public void showAllEmployees() {
        for (var employee : EMPLOYEES.values()) {
            System.out.println(employee);
        }
    }

    public void showEmployeeByPersonalNumber(int personalNumber) {
        System.out.println(searchEmployeeByPersonalNumber(personalNumber));
    }

}
