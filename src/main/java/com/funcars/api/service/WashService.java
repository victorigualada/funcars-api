package com.funcars.api.service;

import com.funcars.api.entity.Employee;
import com.funcars.api.entity.Wash;
import com.funcars.api.repository.WashRepository;
import org.assertj.core.util.IterableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WashService {
    @Autowired
    private WashRepository washRepository;

    public List<Wash> findAll() {
        return (List<Wash>) IterableUtil.toCollection(washRepository.findAll());
    }

    public Optional<Wash> findOne(Long id) {
        return washRepository.findById(id);
    }

    public Long create(Wash wash) {
        Wash savedWash = washRepository.save(wash);
        return savedWash.getId();
    }

    public void deleteById(Long id) {
        washRepository.deleteById(id);
    }

    public void update(Wash wash) {
        create(wash);
    }
}
