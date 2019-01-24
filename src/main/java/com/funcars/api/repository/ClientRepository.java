package com.funcars.api.repository;

import com.funcars.api.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    @Override
    Iterable<Client> findAll();

    @Override
    Optional<Client> findById(Long id);

    @Override
    void delete(Client client);

    @Override
    void deleteById(Long id);

    @Override
    <S extends Client> S save(S s);
}
