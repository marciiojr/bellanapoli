package com.italianrestaurant.reservationservice.services;
import com.italianrestaurant.clientservice.dtos.request.ClientRequest;
import com.italianrestaurant.clientservice.dtos.response.ClientResponse;
import com.italianrestaurant.clientservice.models.Client;
import com.italianrestaurant.reservationservice.dtos.request.ReserveRequest;
import com.italianrestaurant.reservationservice.dtos.response.ReserveResponse;
import com.italianrestaurant.reservationservice.enums.Status;
import com.italianrestaurant.reservationservice.models.Reserve;
import com.italianrestaurant.reservationservice.repositories.ReserveRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReserveService {

    private final ReserveRepository reserveRepository;
    private final ClientService clientService;

    public ReserveService(ReserveRepository reserveRepository, ClientService clientService) {
        this.reserveRepository = reserveRepository;
        this.clientService = clientService;
    }

    public List<ReserveResponse> getAll(){
        return reserveRepository.findAll().stream().map(r -> new ReserveResponse(r.getId(), r.getReservationDate(),
                r.getClientName(), r.getStatus())).collect(Collectors.toList());
    }

    public List<ReserveResponse> getAllActive(){
        return reserveRepository.findAll().stream().filter(r -> r.getStatus().equals(Status.Ativo)).map(r -> new ReserveResponse(r.getId(), r.getReservationDate(),
                r.getClientName(), r.getStatus())).collect(Collectors.toList());
    }

    public ReserveResponse createReservation(ReserveRequest request) {

        String clientName = clientService.getClientNameById(request.getClientId());

        Reserve reserve = new Reserve(null,
                request.getReservationDate(),
                clientName,
                request.getClientId(),
                Status.Ativo
        );

        Reserve createdReserve = reserveRepository.save(reserve);
        return new ReserveResponse(createdReserve.getId(), createdReserve.getReservationDate(), createdReserve.getClientName(), createdReserve.getStatus());
    }

    public ReserveResponse findById(Long id) {
        Reserve reserve = reserveRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Reserva não encontrado!"));
        return mapperToDto(reserve);
    }


    public ReserveResponse update(Long id, ReserveRequest reserveRequest) {
        Reserve reserve = reserveRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva não encontrado"));
        reserve.setReservationDate(reserveRequest.getReservationDate());
        Reserve updatedReserve = reserveRepository.save(reserve);
        return mapperToDto(updatedReserve);
    }

    public ReserveResponse delete(Long id) {
        Reserve reserve = reserveRepository.findById(id).orElseThrow(() -> new RuntimeException(("Reserva não encontrado")));
        reserveRepository.delete(reserve);
        return mapperToDto(reserve);
    }

    public List<ReserveResponse> GetAllByClientId(Long clientId) {
        return reserveRepository.findAll().stream().filter(r -> r.getClientId().equals(clientId)).map(r -> new ReserveResponse(r.getId(), r.getReservationDate(),
                r.getClientName(), r.getStatus())).collect(Collectors.toList());

    }

    public ReserveResponse cancelReservation(Long id) {
        Reserve reserve = reserveRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva não entrada"));
        reserve.setStatus(Status.Cancelado);
        reserveRepository.save(reserve);
        return mapperToDto(reserve);
    }

    public ReserveResponse mapperToDto(Reserve reserve){
        return new ReserveResponse(reserve.getId(), reserve.getReservationDate(), reserve.getClientName(), reserve.getStatus());
    }

    public Reserve mapper(ReserveResponse reserveResponse){
        return new Reserve(null, reserveResponse.getReservationDate(), reserveResponse.getClientName(), reserveResponse.getId(), reserveResponse.getStatus());
    }




}
