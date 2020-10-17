package com.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Repas {

    @Id
    private String nom;
    @OneToMany
    private List<Ingredient> ingredients;
    @OneToOne
    private ApportNutritionnel apportNutritionnel;
}
