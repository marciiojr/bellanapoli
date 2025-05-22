package com.italianrestaurant.menuservice.Services;

import com.italianrestaurant.menuservice.Dtos.Response.DishReponseDTO;
import com.italianrestaurant.menuservice.models.Dish;
import com.italianrestaurant.menuservice.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishService {


    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

   public List<DishReponseDTO> getAll(){

        return dishRepository.findAll().stream().map(d -> new DishReponseDTO(d.getId(), d.getNome(), d.getDescricao(), d.getPreco(), d.getCategoria(), d.isDisponivel())).collect(Collectors.toList());
   }

   public DishReponseDTO getById(long id) {
        Dish dish = dishRepository.findById(id).orElseThrow(() -> new RuntimeException(("Prato não encontrado!")));
        return new DishReponseDTO(dish.getId(), dish.getNome(), dish.getDescricao(), dish.getPreco(), dish.getCategoria(), dish.isDisponivel());
   }





}
