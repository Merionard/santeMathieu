package com.entites;

import javax.persistence.*;
import java.util.List;

@Entity
public class Repas {

    @Id
    private String nom;
    @OneToMany
    private List<Ingredient> ingredients;
    @OneToOne
    private ApportNutritionnel apportNutritionnel;
}
