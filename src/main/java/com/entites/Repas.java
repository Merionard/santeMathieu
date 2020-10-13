package com.entites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Repas {

    @Id
    private String nom;
    @OneToMany
    private List<Ingredient> ingredients;
    private double apportPotassium;
}
