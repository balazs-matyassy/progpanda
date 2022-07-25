package hu.progmatic.progpanda.controller;

import hu.progmatic.progpanda.model.Drink;
import hu.progmatic.progpanda.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DrinkController {
    @Autowired
    DrinkService drinkService;

    @PostMapping("/drinks")
    public String newDrink(Drink drink, Model model) {
        drinkService.saveDrink(drink);
        return "redirect:/drinks";
    }

    @GetMapping(value = {"/", "/drinks"})
    public String getDrinks(Model model) {
        List<Drink> drinks = drinkService.getAll();
        model.addAttribute("newDrink", new Drink());
        model.addAttribute("drinks", drinks);
        return "drinks";
    }

    @GetMapping("/conditions")
    public String displayConditions() {
        return "conditions";
    }
}
