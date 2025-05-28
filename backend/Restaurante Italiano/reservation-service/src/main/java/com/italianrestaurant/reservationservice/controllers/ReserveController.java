package com.italianrestaurant.reservationservice.controllers;

import com.italianrestaurant.clientservice.dtos.request.ClientRequest;
import com.italianrestaurant.clientservice.dtos.response.ClientResponse;
import com.italianrestaurant.reservationservice.dtos.request.ReserveRequest;
import com.italianrestaurant.reservationservice.dtos.response.ReserveResponse;
import com.italianrestaurant.reservationservice.models.Reserve;
import com.italianrestaurant.reservationservice.services.ReserveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReserveController {

    private final ReserveService service;

    public ReserveController(ReserveService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ReserveResponse>> getAllReserves() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/actives")
    public ResponseEntity<List<ReserveResponse>> getAllActivesReserves(){
        return ResponseEntity.ok(service.getAllActive());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReserveResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<ReserveResponse>> getAllByClientId(@PathVariable("id") Long clientId) {
        return ResponseEntity.ok(service.GetAllByClientId(clientId));
    }


    @PostMapping
    public ResponseEntity<ReserveResponse> createReservation(@RequestBody ReserveRequest request) {

        ReserveResponse reserve = service.createReservation(request);
        return ResponseEntity.ok(reserve);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReserveResponse> update(@PathVariable("id") Long id, @RequestBody ReserveRequest reserveRequest) {
        return ResponseEntity.ok(service.update(id, reserveRequest));
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<ReserveResponse> cancel(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.cancelReservation(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ReserveResponse> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }




}
