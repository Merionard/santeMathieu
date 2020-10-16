package com.web;

import com.entites.ApportNutritionnel;
import com.entites.TypeComptabilisation;
import com.repository.ApportNutritionnelRepository;
import com.repository.IngredientRepository;
import com.entites.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ingredient")
public class IngredientRestControler {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private ApportNutritionnelRepository apportNutritionnelRepository;

    @GetMapping("/list")
    public List<Ingredient> getAll() {

        return ingredientRepository.findAll();
    }

    @GetMapping("/{nom}")
    public Ingredient getByName(@PathVariable String nom){
        return ingredientRepository.getByNom(nom);
    }

    @PostMapping(path ="add", consumes = "application/json", produces = "application/json")
    public Ingredient addIngredient(@RequestBody Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    @GetMapping("/add")
    public Ingredient addForTest() {
        ApportNutritionnel apportNutritionnel = new ApportNutritionnel().setPhosphore(10).setCalcium(7);
        apportNutritionnelRepository.save(apportNutritionnel);


      return  ingredientRepository.save(new Ingredient().setNom("Carotte")
                .setTypeComptabilisation(TypeComptabilisation.POIDS)
                .setApportNutritionnel(apportNutritionnel)
        );
    }




}
