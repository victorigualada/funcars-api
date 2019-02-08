package com.funcars.api.controller;

import com.funcars.api.entity.Client;
import com.funcars.api.entity.Employee;
import com.funcars.api.service.ClientService;
import com.funcars.api.service.EmployeeService;
import com.funcars.api.util.RestPreconditions;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @ResponseBody
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Employee> findOne(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(employeeService.findOne(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long create(@RequestBody Employee employee) {
        Preconditions.checkNotNull(employee);
        return employeeService.create(employee);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @RequestBody Employee employee) {
        Preconditions.checkNotNull(employee);
        RestPreconditions.checkNotNull(employeeService.findOne(employee.getId()));
        employeeService.update(employee);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
    }
}
