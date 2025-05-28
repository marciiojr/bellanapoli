package com.italianrestaurant.reservationservice.dtos.request;

import com.italianrestaurant.reservationservice.enums.Status;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReserveRequest {

    private LocalDateTime reservationDate;
    private Long clientId;


    public ReserveRequest() {
    }

    public ReserveRequest(LocalDateTime reservationDate, Long clientId) {
        this.reservationDate = reservationDate;
        this.clientId = clientId;

    }
}
