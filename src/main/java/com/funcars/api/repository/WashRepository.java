package com.funcars.api.repository;

import com.funcars.api.entity.Wash;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WashRepository extends CrudRepository<Wash, Long> {

    @Override
    Iterable<Wash> findAll();

    @Override
    Optional<Wash> findById(Long id);

    @Override
    void delete(Wash wash);

    @Override
    void deleteById(Long id);

    @Override
    <S extends Wash> S save(S s);
}
