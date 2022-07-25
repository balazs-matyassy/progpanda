package hu.progmatic.progpanda.controller;

import hu.progmatic.progpanda.model.Food;
import hu.progmatic.progpanda.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FoodController {
    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/foods")
    public String getFoods(Model model) {
        List<Food> foods = foodService.getAll();
        model.addAttribute("orders", foods);

        return "foods";
    }

    @GetMapping("/delivery")
    public String getDelivery() {
        return "delivery";
    }
}
