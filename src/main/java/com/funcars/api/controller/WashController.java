package com.funcars.api.controller;

import com.funcars.api.entity.Wash;
import com.funcars.api.service.WashService;
import com.funcars.api.util.RestPreconditions;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/washes")
public class WashController {

    @Autowired
    private WashService washService;

    @GetMapping
    @ResponseBody
    public List<Wash> findAll() {
        return washService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Wash> findOne(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(washService.findOne(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long create(@RequestBody Wash wash) {
        Preconditions.checkNotNull(wash);
        return washService.create(wash);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @RequestBody Wash wash) {
        Preconditions.checkNotNull(wash);
        RestPreconditions.checkNotNull(washService.findOne(wash.getId()));
        washService.update(wash);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        washService.deleteById(id);
    }
}
