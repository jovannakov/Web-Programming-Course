package mk.finki.ukim.mk.lab.repository.RepositoryImplementation;

import mk.finki.ukim.mk.lab.data.DataHolder;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PizzaRepoImpl implements PizzaRepository {

    @Override
    public List<Pizza> listAllPizzas() {
        return DataHolder.pizzas;
    }

    @Override
    public Optional<Pizza> FindByName(String pizza) {
        return DataHolder.pizzas.stream()
                .filter(p -> p.getName().equals(pizza))
                .findFirst();
    }

    @Override
    public void DeleteByName(String pizza) {
        this.FindByName(pizza)
                .ifPresent(DataHolder.pizzas::remove);
    }

}
