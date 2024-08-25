package io.orangetech.cars;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CarService {

    @Inject
    CarRepository carRepository;


    public List<Car> getAll(){
        return carRepository.findAll().stream().toList();
    }

    @Transactional
    public Car getCar(long id){
        Car car = carRepository.findById(id);
        if (car == null){
            throw new RuntimeException();
        }
        return car;
    }

    @Transactional
    public void addCar(CarRequest CarRequest){
        Car car = new Car();
        car.setType(CarRequest.getType());
        car.setColour(CarRequest.getColour());
        car.setModel(CarRequest.getModel());
        car.setYear(CarRequest.getYear());
        carRepository.persist(car);

    }

    @Transactional
    public void updateCar(long id, CarRequest carRequest){
        Car car = carRepository.findById(id);
        if(car == null){
            throw new RuntimeException();
        } else{
            car.setYear(carRequest.getYear());
            car.setColour(carRequest.getColour());
            car.setModel(carRequest.getModel());
            car.setType(carRequest.getType());
            carRepository.persist(car);
        }
    }

    @Transactional
    public void deleteCar(long id){
        Car car = carRepository.findById(id);
        if (car == null){
            throw new RuntimeException();
        }else{
            carRepository.deleteById(id);
        }
    }

}
