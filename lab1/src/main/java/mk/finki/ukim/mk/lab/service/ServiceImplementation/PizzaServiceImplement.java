package mk.finki.ukim.mk.lab.service.ServiceImplementation;

import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaServiceImplement implements PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaServiceImplement(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }


    @Override
    public List<Pizza> listAllPizzas() {
        return pizzaRepository.listAllPizzas();
    }

    @Override
    public void DeleteByName(String name) {
        pizzaRepository.DeleteByName(name);
    }

    @Override
    public Optional<Pizza> FindByName(String name) {
        return pizzaRepository.FindByName(name);
    }


}
