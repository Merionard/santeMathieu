package com.web;

import com.entites.*;
import com.repository.PlatRepository;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("plat")
@Accessors(chain = true)
@CrossOrigin("*")
public class PlatRestControler {

    @Autowired
    private PlatRepository platRepository;


    @GetMapping("/list")
    public List<Plat> getAll() {

        return platRepository.findAll();
    }


    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public Plat addIngredient(@RequestBody Plat plat) {
        return platRepository.save(plat);
    }

    @PostMapping(path = "/delete", consumes = "application/json", produces = "application/json")
    public String deleteIngredient(@RequestBody Plat plat) {
        platRepository.delete(plat);
        return "le repas " + plat.getNom() + " a été supprimé";
    }
    @GetMapping("/addTest")
    public Plat addForTest(){
        Plat plat = new Plat()
                .setNom("test")
                .setApportNutritionnel(new ApportNutritionnel().setCalcium(1.2).setPhosphore(3).setMagnesium(0))
                .setRecette(new Recette()
                        .addLigne(new LigneRecette()
                                .setIngredient(
                                        new Ingredient()
                                                .setNom("testIngredient")
                                ).setQuantite(3)
                                ));

        return platRepository.save(plat);
    }


}
