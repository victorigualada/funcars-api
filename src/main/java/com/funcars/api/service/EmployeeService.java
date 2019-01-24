package com.funcars.api.service;

import com.funcars.api.entity.Car;
import com.funcars.api.entity.Employee;
import com.funcars.api.repository.EmployeeRepository;
import org.assertj.core.util.IterableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return (List<Employee>) IterableUtil.toCollection(employeeRepository.findAll());
    }

    public Optional<Employee> findOne(Long id) {
        return employeeRepository.findById(id);
    }

    public Long create(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee.getId();
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
