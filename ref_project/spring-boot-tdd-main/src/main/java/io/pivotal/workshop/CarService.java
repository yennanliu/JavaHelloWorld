package io.pivotal.workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String name) {
         Car car = carRepository.findByName(name);
         if (car == null){
             throw new CarNotFoundException();
         }

         // Dummy business logic we want to unit-test
         car.setType(car.getType() + "1");

         return car;
    }

    public Car addCarDetails(Car car) {
        return carRepository.save(car);
    }
}
