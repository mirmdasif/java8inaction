package net.asifhossain.java8inaction.chapter1.comparator;

import net.asifhossain.java8inaction.domain.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.sort(Comparator.comparingInt(Employee::getSalary));
        employees.sort(Comparator.comparingInt(Employee::getYearsOfExperience));
    }
}

