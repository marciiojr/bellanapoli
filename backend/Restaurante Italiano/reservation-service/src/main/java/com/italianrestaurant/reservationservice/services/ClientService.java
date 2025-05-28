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

    public static class ClientResponse {
        private String nome;

        public String getNome() { return nome; }
        public void setName(String nome) { this.nome = nome; }
    }

}
