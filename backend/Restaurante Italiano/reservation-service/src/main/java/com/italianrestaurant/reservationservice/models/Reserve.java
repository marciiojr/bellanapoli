package com.italianrestaurant.reservationservice.models;

import com.italianrestaurant.reservationservice.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime  reservationDate;
    private String clientName;
    private String clientEmail;
    private Long clientId;
    private Status status;

    public Reserve(Long id, LocalDateTime reservationDate, String clientName, Long clientId, Status status,String clientEmail) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.clientName = clientName;
        this.clientId = clientId;
        this.status = status;
        this.clientEmail = clientEmail;
    }

    public Reserve() {

    }


}
