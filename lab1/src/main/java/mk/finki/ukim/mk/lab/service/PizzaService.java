package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaService {

    List<Pizza> listAllPizzas();

    void DeleteByName(String name);

    Optional<Pizza> FindByName(String name);

}
