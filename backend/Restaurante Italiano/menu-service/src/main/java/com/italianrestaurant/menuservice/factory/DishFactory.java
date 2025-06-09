package com.italianrestaurant.menuservice.factory;

import com.italianrestaurant.menuservice.models.Categoria;
import com.italianrestaurant.menuservice.models.Dish;
import org.springframework.stereotype.Component;

@Component
public class DishFactory {

    public Dish createDish(Categoria categoria, String nome, String descricao, double preco, boolean disponivel) {
        Dish dish = new Dish();
        dish.setNome(nome);
        dish.setDescricao(descricao);
        dish.setPreco(preco);
        dish.setDisponivel(disponivel);
        dish.setCategoria(categoria);


        switch (categoria) {
            case ENTRADA -> dish.setPreco(preco * 0.9); // 10% de desconto para entrada
            case SOBREMESA -> dish.setDescricao(descricao + " (Doce delicioso!)");
            case BEBIDA -> dish.setDisponivel(true);
            case PRATO_PRINCIPAL -> {}
        }

        return dish;
    }
}
