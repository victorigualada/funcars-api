package com.funcars.api.service;

import com.funcars.api.entity.Car;
import com.funcars.api.entity.Client;
import com.funcars.api.repository.CarRepository;
import com.funcars.api.repository.ClientRepository;
import org.assertj.core.util.IterableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> findAll() {
        return (List<Car>) IterableUtil.toCollection(carRepository.findAll());
    }

    public Optional<Car> findOne(Long id) {
        return carRepository.findById(id);
    }

    public Long create(Car car) {
        Car savedCar = carRepository.save(car);
        return savedCar.getId();
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
