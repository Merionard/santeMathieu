package com.application.web;

import com.application.Repository.IngredientRepository;
import com.application.entites.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ingredient")
public class IngredientRestControler {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        ingredientRepository.save(new Ingredient().setNom("Patate"));
        return String.format("Hello %s!", name);
    }
}
