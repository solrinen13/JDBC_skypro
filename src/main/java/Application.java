import DAO.EmployeeDAOImpl;
import model.Employee;
import org.jetbrains.annotations.NotNull;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Application {
    public static void main(String[] args) {


          EmployeeDAOImpl service = new EmployeeDAOImpl();
//        Employee employee = new Employee();
//        employee.setId(13);
//        employee.setFirstName("Cheburek");
//        employee.setLastName("Со свином");
//        employee.setGender("M");
//        employee.setAge(500);
//        employee.setCityId(3);

       // System.out.println(employee);
       // service.update(employee);
        //service.deleteById(employee);
        System.out.println(service.findById(15L));
       //service.findAll().forEach((e)->System.out.println(e));
    }
}
