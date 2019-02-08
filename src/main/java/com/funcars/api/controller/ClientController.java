package com.funcars.api.controller;

import com.funcars.api.entity.Client;
import com.funcars.api.service.ClientService;
import com.funcars.api.util.RestPreconditions;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    @ResponseBody
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Client> findOne(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(clientService.findOne(id));
    }

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   @ResponseBody
   public Long create(@RequestBody Client client) {
       Preconditions.checkNotNull(client);
       return clientService.create(client);
   }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @RequestBody Client client) {
        Preconditions.checkNotNull(client);
        RestPreconditions.checkNotNull(clientService.findOne(client.getId()));
        clientService.update(client);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        clientService.deleteById(id);
    }
}
