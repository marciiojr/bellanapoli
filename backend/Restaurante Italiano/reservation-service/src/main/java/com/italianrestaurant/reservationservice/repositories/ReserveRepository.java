package com.italianrestaurant.reservationservice.repositories;

import com.italianrestaurant.reservationservice.models.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {
}
