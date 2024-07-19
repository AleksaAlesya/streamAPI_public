package org.example.streamApi;

import java.util.ArrayList;
import java.util.List;

public class Department {
    String name;
    List<Employee>employeeListOnDepartment;

    public Department(String name) {
        this.name = name;
        this.employeeListOnDepartment = new ArrayList<>();
    }

    public List<Employee> getEmployeeListOnDepartment() {
        return employeeListOnDepartment;
    }

    public void addEmployee(Employee employee){
        employeeListOnDepartment.add(employee);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeListOnDepartment(List<Employee> employeeListOnDepartment) {
        this.employeeListOnDepartment = employeeListOnDepartment;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", employeeListOnDepartment=" + employeeListOnDepartment +
                '}';
    }
}
