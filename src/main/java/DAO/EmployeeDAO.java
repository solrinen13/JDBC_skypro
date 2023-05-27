package DAO;


import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee findById(Long id);
    void update(Employee employee);
    void save(Employee employee);
    void delete(Employee employee);

    List<Employee> findAll();
}
