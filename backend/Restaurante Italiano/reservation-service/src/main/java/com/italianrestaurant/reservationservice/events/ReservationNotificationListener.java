package com.italianrestaurant.reservationservice.events;

import com.italianrestaurant.reservationservice.models.Reserve;
import com.italianrestaurant.reservationservice.services.EmailService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class ReservationNotificationListener {
    private final EmailService emailService;

    public ReservationNotificationListener(EmailService emailService) {
        this.emailService = emailService;
    }


    @EventListener
    public void handleReservationCreated(ReservationCreatedEvent event) {
        Reserve reservation = event.getReservation();
        String clientEmail = reservation.getClientEmail();
        if (clientEmail != null && !clientEmail.isBlank()) {
            String subject = "Sua reserva foi confirmada";
            String body = "Olá " + reservation.getClientName() +
                    ", sua reserva foi confirmada para o dia " + reservation.getReservationDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " as " +reservation.getReservationDate().format(DateTimeFormatter.ofPattern("HH:mm"));

            emailService.sendReservationNotification(clientEmail, subject, body);
        } else {
            System.out.println("⚠️ Nenhum e-mail associado à reserva: " + reservation.getId());
        }

    }
}
