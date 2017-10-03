package net.asifhossain.java8inaction.domain;

public class Employee {
    private int salary;
    private int yearsOfExperience;

    Employee(int weight, int yearsOfExperience) {
        this.salary = weight;
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getSalary() {
        return salary;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
}
