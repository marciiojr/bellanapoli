package com.italianrestaurant.menuservice.Services;

import com.italianrestaurant.menuservice.Dtos.Request.DishRequestDTO;
import com.italianrestaurant.menuservice.Dtos.Response.DishReponseDTO;
import com.italianrestaurant.menuservice.models.Dish;
import com.italianrestaurant.menuservice.repositories.DishRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DishService {

    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<DishReponseDTO> findAll() {
        return dishRepository.findAll().stream().map(d ->
                new DishReponseDTO(d.getId(), d.getNome(), d.getDescricao(), d.getPreco(),
                        d.getCategoria(), d.isDisponivel())).collect(Collectors.toList());
    }

    public DishReponseDTO findById(Long id) {
        Dish dish = dishRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Prato não encontrado!"));
        return mapper(dish);
    }

    public DishReponseDTO create(DishRequestDTO dishRDto){
        Dish dish = new Dish(null, dishRDto.getNome(), dishRDto.getDescricao(), dishRDto.getPreco(), dishRDto.getCategoria(), dishRDto.isDisponivel());
        Dish createdDish = dishRepository.save(dish);
        return mapper(createdDish);


    }

    public DishReponseDTO mapper(Dish dish){
        return new DishReponseDTO(dish.getId(), dish.getNome(), dish.getDescricao(),
                dish.getPreco(), dish.getCategoria(),dish.isDisponivel());
    }
}


