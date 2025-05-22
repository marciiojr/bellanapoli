package com.italianrestaurant.menuservice.repositories;

import com.italianrestaurant.menuservice.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
}
