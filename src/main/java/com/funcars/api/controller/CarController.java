package com.funcars.api.controller;

import com.funcars.api.entity.Car;
import com.funcars.api.service.CarService;
import com.funcars.api.util.RestPreconditions;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    @ResponseBody
    public List<Car> findAll() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Car> findOne(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(carService.findOne(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long create(@RequestBody Car car) {
        Preconditions.checkNotNull(car);
        return carService.create(car);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @RequestBody Car car) {
        Preconditions.checkNotNull(car);
        RestPreconditions.checkNotNull(carService.findOne(car.getId()));
        carService.update(car);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        carService.deleteById(id);
    }
}
