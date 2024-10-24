package org.example.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestCollectsGroupingBy {
    public static void main(String[] args) {
        Employee employee0 = new Employee("Petrov", "Sergey", 45, Position.DIRECTOR, 5000.0);

        Employee employee1 = new Employee("Sidorov", "Evgen", 40, Position.HR, 2500.0);
        Employee employee2 = new Employee("Getrov", "Alex", 24, Position.MANAGER, 1000.0);
        Employee employee3 = new Employee("Petrov", "Nikolya", 24, Position.MANAGER, 1500.0);
        Employee employee4 = new Employee("Meller", "Peter", 24, Position.MANAGER, 2000.0);
        Employee employee5 = new Employee("Myhin", "Petya", 58, Position.HR, 3000.0);

      List<Employee> allEmployeeList = new ArrayList<>(Arrays.asList(employee0, employee1, employee2, employee3, employee4, employee5,employee0));

      //Группировка по возрасту
//        Map <Integer, List<Employee>> map = allEmployeeList.stream().collect(Collectors.groupingBy(employee -> employee.getAge()));
//        System.out.println(map);
//
        //Группировка по возрасту вывыести списки
        Map<Integer, List<String>> map1 =
                allEmployeeList.stream().collect(Collectors.groupingBy(employee -> employee.getAge(),Collectors.mapping(Employee::getName,Collectors.toList())));



















        //Группировка по ЗП
        Map<Double,List<Employee>> groupingBySalary =allEmployeeList.stream().collect(Collectors.groupingBy(employee->employee.getSalary()));
        System.out.println(groupingBySalary);

        for (Map.Entry<Double,List<Employee>> entry : groupingBySalary.entrySet()) {
            System.out.println(entry.getKey() +":"+ entry.getValue().toString());

        }

    }
}
