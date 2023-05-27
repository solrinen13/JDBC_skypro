import DAO.EmployeeDAOImpl;
import model.Employee;
import org.jetbrains.annotations.NotNull;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Application {
    public static void main(String[] args) {


          EmployeeDAOImpl service = new EmployeeDAOImpl();
        Employee employee = new Employee();
        employee.setId(15L);
        employee.setFirstName("Mark");
        employee.setLastName("Hunter");
        employee.setGender("m");
        employee.setAge(45);
        employee.setCityId(1);

       // System.out.println(employee);
       // service.update(employee);
        service.delete(employee);
        //System.out.println(service.findById(15L));
       service.findAll().forEach((e)->System.out.println(e));
    }
}
