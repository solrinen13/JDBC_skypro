package DAO;


import post.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee findById(Integer id);
    Employee update(Employee employee);
    void create(Employee employee);
    void deleteById(Integer id);

    List<Employee> findAll();
}
