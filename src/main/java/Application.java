import DAO.EmployeeDAOImpl;
import model.Employee;
import org.jetbrains.annotations.NotNull;


public class Application {
    public static void main(String[] args) {
        EmployeeDAOImpl service = new EmployeeDAOImpl();
        Employee employee = new Employee();
        employee.setFirst_name("Cheburek");
        employee.setLast_name("Со свином");
        employee.setGender("M");
        employee.setAge(500);
        employee.setCity_id(3);

        System.out.println(employee);
        service.save(employee);
        System.out.println(employee);
    }
}
