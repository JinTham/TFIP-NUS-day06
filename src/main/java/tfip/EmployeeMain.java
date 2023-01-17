package tfip;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String[] args){
        ///Create list of employees
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1,"Adam","Cheng",50000));
        employees.add(new Employee(1,"Adam","Biu",50000));
        employees.add(new Employee(2,"Bertram","Chong",60000));
        employees.add(new Employee(3,"Naing","Than",70000));
        employees.add(new Employee(4,"Kenghou","Loo",80000));
        employees.add(new Employee(5,"Jingjie","Ong",90000));
        employees.add(new Employee(6,"Yukuan","Tan",100000));
        ///Filter
        List<Employee> filteredEmployees = employees.stream().filter(emp->emp
        .getLastName().contains("Ch"))
        .collect(Collectors.toList()); //convert stream into List
        ///Printout filtered employees
        filteredEmployees.forEach(emp->System.out.println(emp));
        ///Sort (option1)
        employees.sort(Comparator.comparing(emp->emp.getFirstName())); //option1
        ///Sort (option2)
        employees.sort(Comparator.comparing(Employee::getFirstName).reversed()); //option2
        ///Sort (option3)
        Comparator<Employee> compare = Comparator.comparing(emp->emp.getFirstName()); //option3
        employees.sort(compare.reversed());
        ///Sort by multiple criteria
        Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);
        employees.sort(groupByComparator);
        ///Printout employees
        employees.forEach(emp->System.out.println(emp));
    
    }
}
