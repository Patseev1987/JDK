package org.example.sem4;

import java.time.LocalDate;

public class Employee {
    private int personalNumber;
    private String phoneNumber;
    private String name;
    private  int workExperience;
    private LocalDate startWorkingDate;

    public Employee(int tabNumber, String phoneNumber, String name, LocalDate startWorkingDate) {
        this.personalNumber = tabNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.startWorkingDate = startWorkingDate;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getWorkExperience() {
        int years = LocalDate.now().getYear() -startWorkingDate.getYear();
        int months = LocalDate.now().getMonthValue() - startWorkingDate.getMonthValue();
        int days = LocalDate.now().getDayOfMonth() - startWorkingDate.getDayOfMonth();
        if (days<15) {
            workExperience = years * 12 + months;
        }else{
            workExperience = years * 12 + months +1;
        }

        return workExperience;
    }

    public LocalDate getStartWorkingDate() {
        return startWorkingDate;
    }


    @Override
    public String toString() {
        return String.format("Personal number - %d\nPhone number - %s\nName - %s\nWork experience - %d(in months)\n",
                personalNumber,phoneNumber,name,getWorkExperience());
    }
}
