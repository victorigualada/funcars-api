package com.funcars.api.service;

import com.funcars.api.entity.Client;
import com.funcars.api.repository.ClientRepository;
import org.assertj.core.util.IterableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return (List<Client>) IterableUtil.toCollection(clientRepository.findAll());
    }

    public Optional<Client> findOne(Long id) {
        return clientRepository.findById(id);
    }

    public Long create(Client client) {
        Client savedClient = clientRepository.save(client);
        return savedClient.getId();
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    public void update(Client client) {
        create(client);
    }
}
