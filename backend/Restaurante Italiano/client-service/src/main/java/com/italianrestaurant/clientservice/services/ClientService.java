package com.italianrestaurant.clientservice.services;

import com.italianrestaurant.clientservice.dtos.request.ClientRequest;
import com.italianrestaurant.clientservice.dtos.response.ClientResponse;
import com.italianrestaurant.clientservice.models.Client;
import com.italianrestaurant.clientservice.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<ClientResponse> findAll() {
        return repository.findAll().stream().map(d ->
                new ClientResponse(d.getId(), d.getNome(), d.getCpf(),d.getEmail(), d.getTelefone(),d.getEndereco()
                        )).collect(Collectors.toList());
    }

    public ClientResponse findById(Long id) {
        Client client = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Cliente não encontrado!"));
        return mapperToDto(client);
    }

    @Transactional
    public ClientResponse create(ClientRequest clientRDto){
        Client client = mapper(clientRDto);
        Client createdClient = repository.save(client);
        return mapperToDto(createdClient);


    }

    public ClientResponse update(Long id, ClientRequest clientRDto) {
        Client client = repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        client.setNome(clientRDto.getNome());
        client.setCpf(clientRDto.getCpf());
        client.setEmail(clientRDto.getEmail());
        client.setEndereco(clientRDto.getEndereco());
        client.setTelefone(clientRDto.getTelefone());
        client.setSenha(clientRDto.getSenha());
        Client updatedClient = repository.save(client);
        return mapperToDto(updatedClient);
    }

    public ClientResponse delete(Long id) {
        Client client = repository.findById(id).orElseThrow(() -> new RuntimeException(("Cliente não encontrado")));
        repository.delete(client);
        return mapperToDto(client);
    }

    public ClientResponse mapperToDto(Client client){
        return new ClientResponse(client.getId(), client.getNome(), client.getCpf(),client.getEmail(), client.getTelefone(),client.getEndereco());
    }

    public Client mapper(ClientRequest clientRDto){
        return new Client(null, clientRDto.getNome(), clientRDto.getCpf(),clientRDto.getEmail(),clientRDto.getEndereco(), clientRDto.getSenha(), clientRDto.getTelefone());
    }
}
