package hu.progmatic.progpanda.service;

import hu.progmatic.progpanda.model.Food;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class FoodService {
    private int counter = 0;
    private Map<Integer, Food> foods = new TreeMap<>();

    public FoodService() {
        saveFood(new Food("Pizza", 2));
        saveFood(new Food("Hamburger", 3));
    }

    public List<Food> getAll() {
        return new ArrayList<>(foods.values());
    }

    public Food getById(int id) {
        return foods.get(id);
    }

    // INSERT + UPDATE (2 in 1)
    public Food saveFood(Food food) {
        if (food.getId() == null) {
            counter++;
            food.setId(counter);
        }

        foods.put(food.getId(), food);

        return food;
    }
}
