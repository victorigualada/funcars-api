package com.funcars.api.repository;

import com.funcars.api.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    @Override
    Iterable<Car> findAll();

    @Override
    Optional<Car> findById(Long id);

    @Override
    void delete(Car car);

    @Override
    void deleteById(Long id);

    @Override
    <S extends Car> S save(S s);
}
