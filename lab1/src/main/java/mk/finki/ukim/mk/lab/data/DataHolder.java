package mk.finki.ukim.mk.lab.data;


import lombok.Getter;
import mk.finki.ukim.mk.lab.model.Pizza;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static final List<Pizza> pizzas = new ArrayList<>();


    @PostConstruct
    public  void init(){
        pizzas.add(new Pizza("Margherita", "Description 1"));
        pizzas.add(new Pizza("Carbonara", "Description 2"));
        pizzas.add(new Pizza("Vegetariana", "Description 3"));
        pizzas.add(new Pizza("Calzone", "Description 4"));
        pizzas.add(new Pizza("Cheddar", "Description 5"));
        pizzas.add(new Pizza("Capricciosa", "Description 6"));
        pizzas.add(new Pizza("Burger Classic", "Description 7"));
        pizzas.add(new Pizza("Boston Barbecue", "Description 8"));
        pizzas.add(new Pizza("Vegie Vulcano", "Description 9"));
        pizzas.add(new Pizza("Boston Barbecue", "Description 10"));
    }


}
