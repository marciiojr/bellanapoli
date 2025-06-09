package com.italianrestaurant.reservationservice.events;

import com.italianrestaurant.reservationservice.models.Reserve;
import org.springframework.context.ApplicationEvent;

public class ReservationCreatedEvent extends ApplicationEvent {
    private final Reserve reservation;

    public ReservationCreatedEvent(Object source, Reserve reservation) {
        super(source);
        this.reservation = reservation;
    }

    public Reserve getReservation() {
        return reservation;
    }
}
