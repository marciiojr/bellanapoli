package com.italianrestaurant.menuservice.repositories;

import com.italianrestaurant.menuservice.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
