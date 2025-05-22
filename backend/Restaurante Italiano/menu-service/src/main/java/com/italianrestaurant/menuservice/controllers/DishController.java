package com.italianrestaurant.menuservice.controllers;

import com.italianrestaurant.menuservice.Dtos.Request.DishRequestDTO;
import com.italianrestaurant.menuservice.Dtos.Response.DishReponseDTO;
import com.italianrestaurant.menuservice.Services.DishService;
import com.italianrestaurant.menuservice.repositories.DishRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pratos")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/teste")
    public String teste() {
        return "ok";
    }

@GetMapping
public ResponseEntity<List<DishReponseDTO>> findAll() {
return ResponseEntity.ok(dishService.findAll());
}

    @GetMapping("/{id}")
public ResponseEntity<DishReponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(dishService.findById(id));
}

@PostMapping
public ResponseEntity<DishReponseDTO> create(@RequestBody DishRequestDTO dishRequestDTO ) {
        return ResponseEntity.ok(dishService.create(dishRequestDTO));
}

    @PutMapping("/{id}")
    public ResponseEntity<DishReponseDTO> update(@PathVariable("id") Long id, @RequestBody DishRequestDTO dishRequestDTO) {
        return ResponseEntity.ok(dishService.update(id, dishRequestDTO));
    }
@DeleteMapping("/{id}")
public ResponseEntity<DishReponseDTO> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(dishService.delete(id));
}
}
