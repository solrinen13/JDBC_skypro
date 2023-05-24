package DAO;

import post.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final Connection connection;



    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Employee findById(Integer id) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee  WHERE id = (?)")) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Employee.create(resultSet);
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee update(Employee employee) {

        try(
                PreparedStatement preparedStatement = connection.prepareStatement("update employee set(first_name, last_name, gender,age,city_id) =  ( ?, ?, ?, ?, ?) where (id) = (?) ")) {

            preparedStatement.setString(1, employee.getFirst_name());
            preparedStatement.setString(2, employee.getLast_name());
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setInt(4, employee.getAge());
            preparedStatement.setObject(5, employee.getCity_id());
            preparedStatement.setInt(6, employee.getId());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public void create(Employee employee) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee (first_name, last_name, gender,age,city_id) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, employee.getFirst_name());
            preparedStatement.setString(2, employee.getLast_name());
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setInt(4, employee.getAge());
            preparedStatement.setObject(5, employee.getCity_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE id = ?")) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> findAll() {
        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee ")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Employee> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(Employee.create(resultSet));
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
