package net.asifhossain.java8inaction.chapter1.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import net.asifhossain.java8inaction.domain.Employee;

/**
 * @author asif.hossain
 * @since 7/10/17.
 */
@SuppressWarnings("all")
public class ComparatorRefactor {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        // Sorting By Salary
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary() - o2.getSalary();
            }
        });

        // Sorting By Years of experience
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary() - o2.getSalary();
            }
        });


        // This codes looks ugly (At least it was ugly before java 8 came.
        // Java 8 Introduced lambda operator which let you replace functional interfaces with lambda expression.
        // Functional interfaces are those interfaces where there is only one method like Comparator interface.

        employees.sort((Employee e1, Employee e2) -> {
            return e1.getSalary() - e2.getSalary();
        });

        employees.sort((Employee e1, Employee e2) -> {
            return e1.getYearsOfExperience() - e2.getYearsOfExperience();
        });

        // Now this code looks a lot better. We have removed unnecessary function and interface name,  but this can be further improved.
        // Since lambdas can be returned from function lets write separate methods for returning the the comparators

        employees.sort(salaryComparator());
        employees.sort(yearsOfExperienceComparator());

        // The code looks a lot cleaner but we refactor it further.
        // both salaryComparator and yearsOfExperience comparator are very similar.
        // Essentially both of them are comparing two integers

        // So we will create a method which looks somewhat like this.
        //        public static Comparator<Employee> intComparator() {
        //
        //        }

        // But we need some mechanism to pass behaviour to our method to extract proper field(Salary, yearsOfExperience)
        // Sounds like a perfect place for Functional Interface.
        employees.sort(intComparator((Employee e) -> e.getSalary()));
        employees.sort(intComparator((Employee e) -> e.getYearsOfExperience()));

        // This looks elegant. We are passing behaviour to intComparator method which is returning some code/behaviour(read lambda)
        // which then used

        employees.sort(intComparator(Employee::getSalary));
        employees.sort(intComparator(Employee::getYearsOfExperience));

        employees.sort(Comparator.comparingInt(Employee::getSalary));
        employees.sort(Comparator.comparingInt(Employee::getYearsOfExperience));
    }

    public static Comparator<Employee> salaryComparator() {
        return (o1, o2) -> o1.getSalary() - o2.getSalary();
    }

    public static Comparator<Employee> yearsOfExperienceComparator() {
        return (e1, e2) -> e1.getYearsOfExperience() - e2.getYearsOfExperience();
    }

    interface IntExtractor<Employee> {
        int extractInt(Employee object);
    }

    public static Comparator<Employee> intComparator(IntExtractor<Employee> extractor) {
        return (Employee e1, Employee e2) -> extractor.extractInt(e1) - extractor.extractInt(e2);
    }
}
