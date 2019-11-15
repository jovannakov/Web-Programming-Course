package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.service.PizzaService;

import java.util.ArrayList;
import java.util.List;

public interface PizzaRepository{

    public List<Pizza> listAllPizzas();

}
