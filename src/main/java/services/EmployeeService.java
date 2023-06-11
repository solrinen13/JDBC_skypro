package services;

import model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    Employee readEmployeeById(int id);

    List<Employee> readAllEmployee();

    Employee updateEmployee(Employee employee);

    boolean deleteEmployeeById(int id);
}
