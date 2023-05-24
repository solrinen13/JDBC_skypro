import DAO.EmployeeDAOImpl;
import post.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        final String username = "postgres";
        final String password = "hos";

        Connection conn = DriverManager.getConnection(url, username, password);
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl(conn);





          System.out.println(employeeDAO.findById(18));
         //employeeDAO.create(new Employee(null,"jdbc first_name" ,"jdbc last_name","jdbc m",  20,3));
        //employeeDAO.update(new Employee(18,"test first_name" ,"test last_name","test m",  23,2));
        //  employeeDAO.deleteById(18);
        //employeeDAO.findAll().forEach(System.out::println);
    }
}
