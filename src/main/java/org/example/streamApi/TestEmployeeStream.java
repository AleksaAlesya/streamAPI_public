package org.example.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestEmployeeStream {
    public static void main(String[] args) {
        Employee employee = new Employee("Petrov","Sergey",45, Position.DIRECTOR,5000.0);

        Employee employee1 = new Employee("Sidorov","Evgen",40, Position.HR,2500.0);
        Employee employee2 = new Employee("Getrov","Alex",24, Position.MANAGER,1000.0);
        Employee employee3 = new Employee("Petrov","Nikolya",24, Position.MANAGER,1500.0);
        Employee employee4 = new Employee("Meller","Peter",24, Position.MANAGER,2000.0);
        Employee employee5 = new Employee("Myhin","Petya",58, Position.HR,3000.0);

        List <Employee> allEmployeeList = new ArrayList<>(Arrays.asList(employee,employee1,employee2,employee3,employee4,employee5));


        //filter
        //count
        // фильтрует сотрудников по зп, у кого более 2000 подсчитывает
      allEmployeeList.stream().filter(e -> {
           //выводит всех , которых б. проверять
           System.out.println(e.getSalary());
           return e.getSalary()>2000.6;
            }).forEach(System.out::println);


        System.out.println("***************");

        //map - на вход один тип, на выход другой Function
        //принимаем коллекцию сотрудников, преобразует и собирает в коллекцию  инт -возраста
        System.out.println(allEmployeeList.stream().map(e->e.getAge()).collect(Collectors.toList()));

        System.out.println("***************");
// отсортируем и выыедем всех сотрудников на букву P
      allEmployeeList.stream().
              filter(e ->  e.getName().startsWith("P")).
             forEach(e-> System.out.println(e.getName() +"  "+e.getLastName()));


        System.out.println("***************");
        List <String> list = Stream.of(employee,employee1,employee2,employee3,employee4).map(e->e.getName()).collect(Collectors.toList());
        System.out.println(list);

        System.out.println("***************");
        System.out.println("Создали лист отдела менеджер");
        List <Employee> managerDepartment = allEmployeeList.stream().
                filter(e-> e.getPosition().equals(Position.MANAGER)).
                collect(Collectors.toList());

        managerDepartment.stream().
                forEach(e-> System.out.println(e.getName()+ " "+ e.getLastName()+ " "+ e.getPosition()));

        System.out.println("***************");
        System.out.println("Создали лист отдела HR");
        List<Employee> hrDepartment = allEmployeeList.stream().
                filter(e->e.getPosition().equals(Position.HR)).
                collect(Collectors.toList());
        hrDepartment.stream().
                forEach(e-> System.out.println(e.getName()+ " "+ e.getLastName()+ " "+ e.getPosition()));


        System.out.println("***************");
        System.out.println("Объединили 2 отдела используя flatMap/ отсортировали");
        List<Employee> joinDepartmentList = Stream.
                of(managerDepartment,hrDepartment).
                flatMap(d->d.stream()).sorted((e1,e2)->e1.getName().compareTo(e2.getLastName())).
                collect(Collectors.toList());
        joinDepartmentList.stream().
                forEach(e-> System.out.println(e.getName()+ " "+ e.getLastName()+ " "+ e.getPosition()));
        System.out.println(joinDepartmentList);

        System.out.println("***************");
        System.out.println("Выводим работника с минимальной ЗП");
        Employee employeeWithMinSalary = allEmployeeList.stream().min(Comparator.comparing(e->e.getSalary())).get();
        System.out.println(employeeWithMinSalary);

        System.out.println("***************");
        System.out.println("Выводим работника с макс ЗП");
        Employee employeeWithMaxSalary =allEmployeeList.stream().
                max(Comparator.comparing(e->e.getSalary())).get();
        System.out.println(employeeWithMaxSalary);

        System.out.println("***************");
        System.out.println("Выводим работника мах возраст");
        System.out.println(allEmployeeList.stream().
                max(Comparator.comparing(a->a.getAge())).get());


        System.out.println("***************");
        System.out.println("сумму ЗП всех работников");
        Double allSalary = allEmployeeList.stream().map(e->e.getSalary()).
                reduce((ac,s)->ac+s).get();
        System.out.println(allSalary);

        System.out.println("***************");
        System.out.println("сумму ЗП всех работников");
        Double allSalary1 = allEmployeeList.stream().map(e->e.getSalary()).
                reduce((ac,s)->ac+s).get();
        System.out.println(allSalary1);

        System.out.println("***************");
        System.out.println("Выводим всех сотрудников, отсортировав по зп");
        allEmployeeList.stream().sorted(((e1,e2)->e1.getSalary().compareTo(e2.getSalary()))).forEach(e-> System.out.println(e));


        System.out.println("+++++++++++++++++++++++++");
        System.out.println(nameIngineerSortedForAge(allEmployeeList));


    }


    public static List<String> nameIngineerSortedForAge (List<Employee> employeeList){
        return employeeList.stream()
                .filter(e -> e.getPosition().equals(Position.HR))
                .sorted((e1,e2)->e1.getAge().compareTo(e2.getAge()))
                .map(e->e.getName()).toList();
    }

}
