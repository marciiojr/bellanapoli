package com.italianrestaurant.clientservice.controllers;

import com.italianrestaurant.clientservice.dtos.request.ClientRequest;
import com.italianrestaurant.clientservice.dtos.response.ClientResponse;
import com.italianrestaurant.clientservice.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<ClientResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClientResponse> create(@RequestBody ClientRequest clientRequestDTO ) {
        return ResponseEntity.ok(service.create(clientRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> update(@PathVariable("id") Long id, @RequestBody ClientRequest clientRequestDTO) {
        return ResponseEntity.ok(service.update(id, clientRequestDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ClientResponse> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
