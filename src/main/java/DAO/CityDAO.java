package DAO;

import model.City;

import java.util.List;

public interface CityDAO {
    City add(City city);

    City findById(int id);

    List<City> findAll();

    City update(City city);

    void delete(City city);
}
