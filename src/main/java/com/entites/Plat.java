package com.entites;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@Accessors(chain = true)
public class Plat {

    @Id
    private String nom;
    @OneToOne(cascade = CascadeType.ALL)
    private Recette recette;
    @OneToOne(cascade = CascadeType.ALL)
    private ApportNutritionnel apportNutritionnel;
}
