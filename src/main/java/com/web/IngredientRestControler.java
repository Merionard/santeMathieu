package com.web;

import com.entites.Ingredient;
import com.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ingredient")
public class IngredientRestControler {

    @Autowired
    private IngredientRepository ingredientRepository;


    @GetMapping("/list")
    public List<Ingredient> getAll() {

        return ingredientRepository.findAll();
    }

    @GetMapping("/{nom}")
    public Ingredient getByName(@PathVariable String nom) {
        return ingredientRepository.getByNom(nom);
    }

    @PostMapping(path = "add", consumes = "application/json", produces = "application/json")
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @PostMapping(path = "delete", consumes = "application/json", produces = "application/json")
    public String deleteIngredient(@RequestBody Ingredient ingredient) {
        ingredientRepository.delete(ingredient);
        return "l'ingrédient " + ingredient.getNom() + " a été supprimé";
    }


}
