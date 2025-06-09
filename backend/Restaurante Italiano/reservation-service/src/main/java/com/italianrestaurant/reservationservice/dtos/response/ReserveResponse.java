package com.italianrestaurant.reservationservice.dtos.response;

import com.italianrestaurant.reservationservice.enums.Status;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReserveResponse {
    private Long id;
    private LocalDateTime reservationDate;
    private String clientName;
    private String clientEmail;
    private Status status;

    public ReserveResponse() {
    }

    public ReserveResponse(Long id, LocalDateTime reservationDate, String clientName,Status status,String clientEmail) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.clientName = clientName;
        this.status = status;
        this.clientEmail = clientEmail;
    }
}
