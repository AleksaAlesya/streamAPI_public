package org.example.streamApi;

import java.net.http.HttpHeaders;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.nCopies;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


public class TestCollect {
    public static void main(String[] args) {
        Employee employee = new Employee("Petrov", "Sergey", 45, Position.DIRECTOR, 5000.0);

        Employee employee1 = new Employee("Sidorov", "Evgen", 40, Position.HR, 2500.0);
        Employee employee2 = new Employee("Getrov", "Alex", 24, Position.MANAGER, 1000.0);
        Employee employee3 = new Employee("Petrov", "Nikolya", 24, Position.MANAGER, 1500.0);
        Employee employee4 = new Employee("Meller", "Peter", 24, Position.MANAGER, 2000.0);
        Employee employee5 = new Employee("Myhin", "Petya", 58, Position.HR, 3000.0);

        List<Employee> allEmployeeList = new ArrayList<>(Arrays.asList(employee, employee1, employee2, employee3, employee4, employee5,employee));

        System.out.println("groupingBy вывести всех сотрудников по имени, перевести в заглавные, и сгрупировать по отделам");
        groupingByDepartment(allEmployeeList);

        System.out.println();
        System.out.println("partitioningBy разделить всех сотрудников по ЗП, у кого больше 2000 и меньше");
        partitioningBySalary(allEmployeeList);
//        TreeSet<Employee>employeeTreeSet = allEmployeeList.stream().collect(toCollection(TreeSet::new));
//        System.out.println(employeeTreeSet);


        System.out.println();
        System.out.println("joining - создание строки из потока данных");
        getStringNamesEmployee(allEmployeeList);


        System.out.println();
        System.out.println("Выведет в консоль только уникальные данные и посчитает количество сотрудников");
        System.out.println(allEmployeeList.stream().distinct().peek(System.out::println).count());


        System.out.println();
        System.out.println("//определяет, есть ли хотябы 1 элемент удовлетворяющий условию");
        System.out.println(allEmployeeList.stream().anyMatch(employee6 -> employee.getPosition() ==Position.DIRECTOR));

        System.out.println();
        System.out.println("//все элементы д.  удовлетворять условию");
        System.out.println(allEmployeeList.stream().allMatch(employee6 -> employee.getPosition() ==Position.DIRECTOR));

        System.out.println();
        System.out.println("groupingBy  сгрупировать по возрасту");
        System.out.println(groupingOfAge(allEmployeeList));

        System.out.println();
        System.out.println(" Подсчет количества рабочих, занимаемых конкретную должность");
        System.out.println(countMapPosition(allEmployeeList));;

        System.out.println();
        System.out.println("Группировка списка рабочих по их должности, при этом нас интересуют только имена");
        System.out.println(groupingByDepartmentNameEmployee(allEmployeeList));

        
        System.out.println();
        System.out.println(" Расчет средней зарплаты для данной должности");


        //todo
//        System.out.println(averaginSaleryGroupingByDepartment(allEmployeeList));//


//т.к. Employee не имплементирует компаратор, то в мапу ключом просто так нельзя добавить
        Comparator <Employee> comparator = Comparator.comparing(employee6 -> employee.getName());
        TreeMap<Employee, String> map = new TreeMap<>(comparator);
        map.put(employee1, "test");

        List<String> list = Stream.of("one", "two").toList();
        int sum = Stream.of("one", "two").mapToInt(s -> s.length()).sum();

    }


//    //todo
////    Расчет средней зарплаты для данной должности"
//    public static Map<String,Double> averaginSaleryGroupingByDepartment(List<Employee> employeeList) {
//
//
//        Map<String, Double> map5 = employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::getPosition,
//                        Collectors.averagingInt(Employee::getSalary)));
//
//        return employeeList.stream()
//                .collect(Collectors.groupingBy(employee -> employee.getPosition().name(),
//                        Collectors.averagingInt(Employee::getSalary)));
//    }



//// Группировка списка рабочих по их должности, рабочие представлены только именами единой строкой
//public  static Map<String, String> groupingByDepartmentEmployeeString(List<Employee> employeeList){
//               return employeeList.stream()
//                       .collect(Collectors.groupingBy(employee -> employee.getPosition().name(),
//                               Collectors.mapping(Employee::getName),
//                               Collectors.joining(", ", "{","}")));
//
//    }



//Группировка списка рабочих по их должности и по возрасту.
    public  static Map<String,Map<Integer, List<Employee>>> groupingByDepartmentAndAge(List<Employee> employeeList){
               return employeeList.stream()
                       .collect(Collectors.groupingBy(employee -> employee.getPosition().name(),
                               Collectors.groupingBy(Employee::getAge)));

    }




    //  groupingBy сгрупировать по должности  все имена перевести в заглавные
    public static Map<String, List<Employee>> groupingByDepartment(List<Employee> employeeList) {
        Map<String, List<Employee>> emplGroupingByDepartment = employeeList.stream()
                .map(employee -> {
                    employee.setName(employee.getName().toUpperCase());
                    return employee;
                })
                .collect(groupingBy(employee -> employee.getPosition().name()));
        System.out.println(emplGroupingByDepartment);
        return emplGroupingByDepartment;
    }


    //  groupingBy  сгрупировать по возрасту 
    public static Map<Integer,List<Employee>> groupingOfAge(List<Employee> employeeList) {

        return  employeeList.stream().collect(Collectors.groupingBy(Employee::getAge));
    }

    //3. Подсчет количества рабочих, занимаемых конкретную должность
      public static Map<String, Long> countMapPosition (List<Employee> employeeList){
        return employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getPosition().name(),Collectors.counting()));
    }

    //Группировка списка рабочих по их должности, при этом нас интересуют только имена (уникальные)
    public static Map<String, Set<String>> groupingByDepartmentNameEmployee (List<Employee> employeeList){
        return employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getPosition().name(),Collectors.mapping(Employee::getName,Collectors.toSet())));
    }

    //  partitioningBy  разделить всех сотрудников по ЗП, у кого больше 2000 и меньше
    public static Map<Boolean, List<Employee>> partitioningBySalary(List<Employee> employeeList) {
        Map<Boolean, List<Employee>> emplPartitioningBySalary = employeeList.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getSalary() > 2000));

        System.out.println(emplPartitioningBySalary);
        return emplPartitioningBySalary;
    }

    // joining - создание строки из потока данных
    public static String getStringNamesEmployee(List<Employee> employeeList) {
        String stringNamesEmployee = employeeList.stream().map(Employee::getName).collect(Collectors.joining(", ", "[", "]"));
        System.out.println(stringNamesEmployee);
        return stringNamesEmployee;
    }

//    @FunctionalInterface
//    public interface HeaderFilter {
//
//        HttpHeaders filter(final HttpHeaders headers);
//
//    }
//
//    public interface HttpHeaders extends Map<String, List<String>> {
//
//        HttpHeaders apply(String name, UnaryOperator<List<String>> operator);
//
//        HttpHeaders apply(
//                Collection<String> names,
//                BiFunction<String, List<String>, Collection<String>> operator);
//
//
//        HttpHeaders apply(
//                BiPredicate<String, List<String>> predicate,
//                BiFunction<String, List<String>, Collection<String>> operator);
//
//        HttpHeaders apply(
//                BiFunction<String, List<String>, Collection<String>> operator);
//
//    }
//
//    private static HeaderFilter replace(final Collection<String> names, final String replacement) {
//        return headers -> {
//            return headers.apply(names, (name, previous) -> {
//                return previous == null ? null : nCopies(previous.size(), replacement);
//            });
//        };
//
//    }
}
