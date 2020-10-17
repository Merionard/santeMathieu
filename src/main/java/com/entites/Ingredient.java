package com.entites;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Accessors(chain = true)
@Data
public class Ingredient {

    @Id
    private String nom;

    private TypeComptabilisation typeComptabilisation;

    @OneToOne(cascade = CascadeType.ALL)
    private ApportNutritionnel apportNutritionnel;

    @Enumerated(EnumType.STRING)
    private CategorieIngredient categorie;
}
