package pp5.services;

import pp5.domain.Car;

import java.util.List;

/**
 * Created by Rafał on 2016-02-19.
 */
public interface CarService {
    List<Car> getAll();
    List<Car> getListOfCar(int count);
    List<Car> getListBySegment(String segment);

    Car getCarById(Integer id);
}
