package hu.progmatic.progpanda.service;

import hu.progmatic.progpanda.model.Drink;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// A @Service egy olyan @Component (ezt is megtalálja a Spring és automatikusan beanként bekerül a kontextusba),
// aminek az a feladata, hogy szolgáltatásokat nyújtson az alkalmazás többi részének.
// Ez a @Service konkrétan az adatbázis szimulációjáért felelős.
// Adattárolásért felelős szolgáltatás.
// Meg lehetett volna @Component annotációval is valósítani, de így sokkal jobban látszik, hogy ez nem egy általános bean.
@Service
public class DrinkService {
    private int counter = 0;
    private Map<Integer, Drink> drinks = new TreeMap<>();

    public DrinkService() {
        saveDrink(new Drink(null, "Beer", 2));
        saveDrink(new Drink(null, "Wine", 3));
    }

    public List<Drink> getAll() {
        return new ArrayList<>(drinks.values());
    }

    public Drink getById(int id) {
        return drinks.get(id);
    }

    public Drink saveDrink(Drink drink) {
        if (drink.getId() == null) {
            counter++;
            drink.setId(counter);
        }

        drinks.put(drink.getId(), drink);

        return drink;
    }
}
