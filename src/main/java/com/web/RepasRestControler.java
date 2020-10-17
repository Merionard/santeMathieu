package com.web;

import com.entites.Ingredient;
import com.entites.Repas;
import com.repository.RepasRepository;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("repas")
@Accessors(chain = true)
public class RepasRestControler {

    @Autowired
    private RepasRepository repasRepository;


    @GetMapping("/list")
    public List<Repas> getAll() {

        return repasRepository.findAll();
    }


    @PostMapping(path = "add", consumes = "application/json", produces = "application/json")
    public Repas addIngredient(@RequestBody Repas repas) {
        return repasRepository.save(repas);
    }

    @PostMapping(path = "delete", consumes = "application/json", produces = "application/json")
    public String deleteIngredient(@RequestBody Repas repas) {
        repasRepository.delete(repas);
        return "le repas " + repas.getNom() + " a été supprimé";
    }


}
