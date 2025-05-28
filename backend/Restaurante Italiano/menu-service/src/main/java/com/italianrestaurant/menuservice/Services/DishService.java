package com.italianrestaurant.menuservice.Services;

import com.italianrestaurant.menuservice.Dtos.Request.DishRequestDTO;
import com.italianrestaurant.menuservice.Dtos.Response.DishReponseDTO;
import com.italianrestaurant.menuservice.models.Dish;
import com.italianrestaurant.menuservice.repositories.DishRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishService {

    private final DishRepository repository;

    public DishService(DishRepository dishRepository) {
        this.repository = dishRepository;
    }

    public List<DishReponseDTO> findAll() {
        return repository.findAll().stream().map(d ->
                new DishReponseDTO(d.getId(), d.getNome(), d.getDescricao(), d.getPreco(),
                        d.getCategoria(), d.isDisponivel())).collect(Collectors.toList());
    }

    public DishReponseDTO findById(Long id) {
        Dish dish = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Prato não encontrado!"));
        return mapperToDto(dish);
    }

    @Transactional
    public DishReponseDTO create(DishRequestDTO dishRDto){
        Dish dish = mapper(dishRDto);
        Dish createdDish = repository.save(dish);
        return mapperToDto(createdDish);


    }

    public DishReponseDTO update(Long id, DishRequestDTO dishRDto) {
        Dish dish = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        dish.setNome(dishRDto.getNome());
        dish.setDescricao(dishRDto.getDescricao());
        dish.setPreco(dishRDto.getPreco());
        dish.setCategoria(dishRDto.getCategoria());
        dish.setDisponivel(dishRDto.isDisponivel());
        Dish updatedDish = repository.save(dish);
        return mapperToDto(updatedDish);
    }

    public DishReponseDTO delete(Long id) {
        Dish dish = repository.findById(id).orElseThrow(() -> new RuntimeException(("Prato não encontrado")));
        repository.delete(dish);
        return mapperToDto(dish);
    }

    public DishReponseDTO mapperToDto(Dish dish){
        return new DishReponseDTO(dish.getId(), dish.getNome(), dish.getDescricao(),
                dish.getPreco(), dish.getCategoria(),dish.isDisponivel());
    }

    public Dish mapper(DishRequestDTO dishRDto){
        return new Dish(null, dishRDto.getNome(), dishRDto.getDescricao(), dishRDto.getPreco(), dishRDto.getCategoria(), dishRDto.isDisponivel());
    }
}


