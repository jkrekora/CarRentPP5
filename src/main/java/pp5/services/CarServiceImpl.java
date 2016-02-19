package pp5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pp5.domain.Car;
import pp5.respositories.CarRepository;

import java.util.List;

/**
 * Created by Rafał on 2016-02-19.
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getFirstNumberOfCar(int count) {
        return carRepository.findByIdLessThan(count + 1);
    }

    @Override
    public List<Car> getListBySegment(String segment) {
        return carRepository.findBySegment(segment);
    }
}
