package com.entites;

import com.PeriodeEnum;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ReleveInformations {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne
    private Tension tension;

    @Enumerated(EnumType.STRING)
    private PeriodeEnum periode;

    @OneToMany
    private Set<Plat> listPlats = new HashSet<>();

    @OneToOne
    private ApportNutritionnel apportNutritionnel;

    private String remarque;

}
