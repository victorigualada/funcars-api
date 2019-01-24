package com.funcars.api.repository;

import com.funcars.api.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    Iterable<Employee> findAll();

    @Override
    Optional<Employee> findById(Long id);

    @Override
    void delete(Employee employee);

    @Override
    void deleteById(Long id);

    @Override
    <S extends Employee> S save(S s);
}
