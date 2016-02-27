package pp5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pp5.domain.Car;
import pp5.domain.Order;
import pp5.respositories.CarRepository;
import pp5.respositories.OrderRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rafał on 2016-02-19.
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepository carRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getFreeCars() {
        List<Car> cars = carRepository.findAll();
        LinkedList<Car> carsToShow = new LinkedList<>();
        for (Car car : cars) {
            if (isAvailable(car)){
                carsToShow.add(car);
            }
        }
        return carsToShow;
    }

    @Override
    public Car getCarById(Integer id) {
        return carRepository.findOne(id);
    }

    @Override
    public List<Car> getListOfCar(int count) {
        List<Car> cars = carRepository.findAll();
        LinkedList<Car> carsToShow = new LinkedList<>();
        for (Car car : cars){
            if (isAvailable(car)){
                carsToShow.add(car);
                if (carsToShow.size() >= count) {
                    break;
                }
            }
        }
        return carsToShow;
    }

    @Override
    public List<Car> getListBySegment(String segment) {
        List<Car> cars = carRepository.findBySegment(segment);
        LinkedList<Car> carsToShow = new LinkedList<>();
        for (Car car : cars) {
            if (isAvailable(car)){
                carsToShow.add(car);
            }
        }
        return carsToShow;
    }


    public boolean isAvailable(Car car) {
        return !isRent(car) && !isReserved(car);
    }


    private boolean isReserved(Car car) {
        List<Order> orders = orderRepository.findByCarIdOrderByDateOfRentDesc(car);
        for (Order order : orders) {
            if (isaReserved(order)) {
                return true;
            }
        }
        return false;
    }

    private boolean isaReserved(Order order) {
        return order.getDateOfRent().getTime() + TimeUnit.MINUTES.toMillis(3) > System.currentTimeMillis();
    }

    private boolean isRent(Car car) {
        List<Order> orders = orderRepository.findByCarIdOrderByEndDateOfRentDesc(car);
        for (Order order : orders) {
            if (isaRent(order)) {
                return true;
            }
        }
        return false;
    }

    private boolean isaRent(Order order) {
        return order.getEndDateOfRent().getTime()  > System.currentTimeMillis() && order.isConfirmed();
    }
}
