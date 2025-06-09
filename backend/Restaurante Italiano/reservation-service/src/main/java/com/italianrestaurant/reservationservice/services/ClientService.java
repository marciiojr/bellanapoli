package com.italianrestaurant.reservationservice.services;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class ClientService {

    private final RestTemplate restTemplate;

    @Value("${client-service.url}")
    private String clientServiceUrl;

    public ClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public String getClientNameById(Long clientId) {
        String url = clientServiceUrl + "/clientes/" + clientId;
        ClientResponse response = restTemplate.getForObject(url, ClientResponse.class);
        return response != null ? response.getNome() : null;
    }

    public String getClientEmailById(Long clientId) {
        String url = clientServiceUrl + "/clientes/" + clientId;
        ClientResponse response = restTemplate.getForObject(url, ClientResponse.class);
        return response != null ? response.getEmail() : null;
    }

    public static class ClientResponse {
        private String nome;
        private String email;

        public String getNome() { return nome; }
        public void setName(String nome) { this.nome = nome; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }

}
