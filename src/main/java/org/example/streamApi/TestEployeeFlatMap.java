package org.example.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestEployeeFlatMap {
    public static void main(String[] args) {
        Employee employee = new Employee("Petrov","Sergey",45, Position.DIRECTOR,5000.0);
        Employee employee1 = new Employee("Sidorov","Evgen",40, Position.HR,2500.0);
        Employee employee2 = new Employee("Getrov","Alex",24, Position.MANAGER,1000.0);
        Employee employee3 = new Employee("Petrov","Nikolya",24, Position.MANAGER,1500.0);
        Employee employee4 = new Employee("Meller","Peter",24, Position.MANAGER,2000.0);
        Employee employee5 = new Employee("Kot","Petya",22, Position.HR,2700.0);

        List<Employee>allEmployee = new ArrayList<>(Arrays.asList(employee,employee1,employee5,employee3,employee4,employee2));

        Department department = new Department("ManagerDepartment");
        Department department1 = new Department("HRDepartment");

        department.addEmployee(employee2);
        department.addEmployee(employee3);
        department.addEmployee(employee4);
        department1.addEmployee(employee5);
        department1.addEmployee(employee1);

        List <Department> departmentList = new ArrayList<>();
        departmentList.add(department);
        departmentList.add(department1);

        departmentList.stream().
                flatMap(d->d.getEmployeeListOnDepartment().stream()).
                forEach(n-> System.out.println(n.getName()+" "+ n.getLastName()));
        System.out.println(departmentList.stream().mapToLong(d->d.getEmployeeListOnDepartment().size()).sum());

//   Map<String,String> hashMap = allEmployee.stream().collect(Collectors.toMap(Employee::getName,Employee::getLastName)).

List <String> list = allEmployee.stream().map(m->
m.getName()+ " " + m.getLastName()).peek(System.out::println).toList();

        List <String> list1 = allEmployee.stream().map(e->e.getName().toUpperCase()).peek((e) -> System.out.print("!" + e+ " ")).toList();
        System.out.println();
        System.out.println(list1);

    }
}
