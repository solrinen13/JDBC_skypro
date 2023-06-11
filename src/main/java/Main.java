import DAO.CityDAO;
import DAO.CityDAOImpl;
import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        //employeeDAO.save(new Employee("Stepan", "Dmitrievich", "Male", 47, new City(1)));
        //employeeDAO.update(new Employee(24,"Dmitrievich", "Dmitrievich", "Male", 22, new City(3)));
        //employeeDAO.delete(employee);
        //System.out.println(employeeDAO.findById(12));
    //    System.out.println(employeeDAO.findById(14));

        List<Employee> list = employeeDAO.findAll();
        for (Employee emp : list) {
            System.out.println(emp);
        }

//        cityDAO.addCity(new City("Новгород"));
//
//        List<City> list = cityDAO.findAll();
//        list.forEach(System.out::println);

        //  City city = new City("Новиград");
//        cityDAO.save(city);
//        cityDAO.delete(cityDAO.findById(7));
//        cityDAO.update(new City("NVG", 4));
    }

}
